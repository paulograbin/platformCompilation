package de.hybris.platform.europe1.jalo;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.jalo.Catalog;
import de.hybris.platform.catalog.jalo.CatalogManager;
import de.hybris.platform.catalog.jalo.CatalogVersion;
import de.hybris.platform.europe1.constants.Europe1Constants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationManager;
import de.hybris.platform.jalo.enumeration.EnumerationType;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.order.OrderManager;
import de.hybris.platform.jalo.order.price.Tax;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.product.ProductManager;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.util.TaxValue;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


@IntegrationTest
public class Europe1PriceFactoryGetTaxFromCacheIntegrationTest extends ServicelayerBaseTest
{
	private static final String TEST_NAME = Europe1PriceFactoryGetTaxFromCacheIntegrationTest.class.getName();
	private static final String TEST_PRODUCT = "TEST_PRODUCT_" + TEST_NAME;

	private static final String TEST_PRODUCT_TAX_GROUP = "TEST_PRODUCT_TAX_GROUP_" + TEST_NAME;

	private static final String TEST_USER = "TEST_USER_" + TEST_NAME;

	private static final double TAX_VALUE_ONLINE = 120.0;
	private static final double TAX_VALUE_STAGE = 121.0;
	private static final double TAX_VALUE_NULL_CATALOG_VERSION = 122.0;
	private Europe1PriceFactory factory;

	private SessionContext ctx;
	private Tax tax;
	private Product product;
	private EnumerationValue productTaxGroup;
	private CatalogVersion onlineCatalogVersion, stageCatalogVersion;
	private User user;
	private final EnumerationValue userTaxGroup = null;
	private final Date date = new Date();



	@Before
	public void setUp() throws Exception
	{
		factory = Europe1PriceFactory.getInstance();
		ctx = JaloSession.getCurrentSession().getSessionContext();
		final ProductManager productManager = ProductManager.getInstance();
		final UserManager userManager = UserManager.getInstance();
		final OrderManager orderManager = OrderManager.getInstance();
		final CatalogManager catalogManager = CatalogManager.getInstance();
		final EnumerationManager enumerationManager = EnumerationManager.getInstance();
		final EnumerationType productTaxGroupType = EnumerationManager.getInstance()
				.getEnumerationType(Europe1Constants.TYPES.TAX_PRODUCT_GROUP);

		tax = orderManager.createTax("TEST_TAX");
		product = productManager.createProduct(TEST_PRODUCT);
		userManager.createCustomer(TEST_USER);
		productTaxGroup = enumerationManager.createEnumerationValue(productTaxGroupType, TEST_PRODUCT_TAX_GROUP);

		Catalog catalog = catalogManager.createCatalog("productCatalog");
		Language langEN = ctx.getLanguage();
		onlineCatalogVersion = catalogManager.createCatalogVersion(catalog, "online", langEN);
		stageCatalogVersion = catalogManager.createCatalogVersion(catalog, "stage", langEN);

		catalogManager.setCatalogVersion(product, onlineCatalogVersion);
		user = user(TEST_USER);
	}

	@Test
	public void testGetTaxInformationsShouldGetTaxesWithTheSameCatalogVersionWhenGivenCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		List<Europe1TaxInformation> taxInfos = factory.getTaxInformations(product, productTaxGroup, user, userTaxGroup, date);
		//then
		assertThat(taxInfos.size()).isEqualTo(1);
		assertThat(taxInfos.get(0).getTaxRow().getValue()).isEqualTo(TAX_VALUE_ONLINE);
	}

	@Test
	public void testGetTaxInformationsShouldGetTaxesWithoutCatalogVersionWhenGivenNonCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		//when
		List<Europe1TaxInformation> taxInfos = factory.getTaxInformations(product, productTaxGroup, user, userTaxGroup, date);
		//then
		assertThat(taxInfos.size()).isEqualTo(1);
		assertThat(taxInfos.get(0).getTaxRow().getValue()).isEqualTo(TAX_VALUE_NULL_CATALOG_VERSION);
	}

	@Test
	public void testGetTaxInformationsShouldGetTaxesWithoutCatalogVersionAndWithSameCatalogVersionWhenGivenMixedTaxes()
			throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		List<Europe1TaxInformation> taxInfos = factory.getTaxInformations(product, productTaxGroup, user, userTaxGroup, date);
		//then
		assertThat(taxInfos.size()).isEqualTo(2);
		assertThat(taxInfos).extracting(Europe1TaxInformation::getValue).extracting(TaxValue::getValue)
				.containsExactlyInAnyOrder(TAX_VALUE_NULL_CATALOG_VERSION, TAX_VALUE_ONLINE);
	}

	@Test
	public void testGetCachedTaxesShouldGetTaxesWithTheSameCatalogVersionWhenGivenCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getCachedTaxes(product, productTaxGroup, user, userTaxGroup,
				date);
		//then
		assertThat(taxes.size()).isEqualTo(1);
		assertThat(taxes.iterator().next().getValue()).isEqualTo(TAX_VALUE_ONLINE);
	}

	@Test
	public void testGetCachedTaxesShouldGetTaxesWithoutCatalogVersionWhenGivenNonCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getCachedTaxes(product, productTaxGroup, user, userTaxGroup,
				date);
		//then
		assertThat(taxes.size()).isEqualTo(1);
		assertThat(taxes.iterator().next().getValue()).isEqualTo(TAX_VALUE_NULL_CATALOG_VERSION);
	}

	@Test
	public void testGetCachedTaxesShouldGetTaxesWithoutCatalogVersionAndWithSameCatalogVersionWhenGivenMixedTaxes()
			throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getCachedTaxes(product, productTaxGroup, user, userTaxGroup,
				date);
		//then
		assertThat(taxes.size()).isEqualTo(2);
		assertThat(taxes).extracting(Europe1PriceFactory.CachedTaxValue::getValue)
				.containsExactlyInAnyOrder(TAX_VALUE_NULL_CATALOG_VERSION, TAX_VALUE_ONLINE);
	}

	@Test
	public void testGetSuperCachedTaxesShouldGetTaxesWithAllCatalogVersionsWhenGivenCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getSuperCachedTaxes(product, productTaxGroup, user,
				userTaxGroup, date);
		//then
		assertThat(taxes.size()).isEqualTo(2);
		assertThat(taxes).extracting(Europe1PriceFactory.CachedTaxValue::getValue)
				.containsExactlyInAnyOrder(TAX_VALUE_ONLINE, TAX_VALUE_STAGE);
	}

	@Test
	public void testGetSuperCachedTaxesShouldGetTaxesWithoutCatalogVersionWhenGivenNonCatalogBasedTaxes() throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getSuperCachedTaxes(product, productTaxGroup, user,
				userTaxGroup, date);
		//then
		assertThat(taxes.size()).isEqualTo(1);
		assertThat(taxes.iterator().next().getValue()).isEqualTo(TAX_VALUE_NULL_CATALOG_VERSION);
	}

	@Test
	public void testGetSuperCachedTaxesShouldGetTaxesWithoutCatalogVersionAndWithAllCatalogVersionsWhenGivenMixedTaxes()
			throws Exception
	{
		//given
		createTax(productTaxGroup, null, null, TAX_VALUE_NULL_CATALOG_VERSION);
		createTax(productTaxGroup, null, onlineCatalogVersion, TAX_VALUE_ONLINE);
		createTax(productTaxGroup, null, stageCatalogVersion, TAX_VALUE_STAGE);
		//when
		Collection<Europe1PriceFactory.CachedTaxValue> taxes = factory.getSuperCachedTaxes(product, productTaxGroup, user,
				userTaxGroup, date);
		//then
		assertThat(taxes.size()).isEqualTo(3);
		assertThat(taxes).extracting(Europe1PriceFactory.CachedTaxValue::getValue)
				.containsExactlyInAnyOrder(TAX_VALUE_NULL_CATALOG_VERSION, TAX_VALUE_ONLINE, TAX_VALUE_STAGE);
	}

	private User user(final String login)
	{
		if (login == null)
		{
			return null;
		}
		return UserManager.getInstance().getUserByLogin(login);
	}

	private void createTax(final Object product, final Object user, final CatalogVersion catalogVersion, final double taxValue)
			throws Exception
	{
		final Product prod = (product instanceof Product) ? (Product) product : null;
		final EnumerationValue prodGroup = (product instanceof EnumerationValue) ? (EnumerationValue) product : null;
		final User usr = (user instanceof User) ? (User) user : null;
		final EnumerationValue usrGroup = (user instanceof EnumerationValue) ? (EnumerationValue) user : null;

		ComposedType.newInstance(ctx, TaxRow.class, TaxRow.PRODUCT, prod, TaxRow.PG, prodGroup, TaxRow.USER, usr, TaxRow.UG,
				usrGroup, TaxRow.TAX, tax, TaxRow.DATERANGE, null, TaxRow.VALUE, taxValue, TaxRow.CATALOGVERSION, catalogVersion);
	}
}
