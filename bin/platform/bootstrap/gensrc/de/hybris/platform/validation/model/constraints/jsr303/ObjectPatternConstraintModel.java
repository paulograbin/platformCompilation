/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.validation.model.constraints.jsr303;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.validation.enums.RegexpFlag;
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;
import java.util.Set;

/**
 * Generated model class for type ObjectPatternConstraint first defined at extension ruleengineservices.
 * <p>
 * Pattern JSR 303 compatible constraint class.
 */
@SuppressWarnings("all")
public class ObjectPatternConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ObjectPatternConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>ObjectPatternConstraint.regexp</code> attribute defined at extension <code>ruleengineservices</code>. */
	public static final String REGEXP = "regexp";
	
	/** <i>Generated constant</i> - Attribute key of <code>ObjectPatternConstraint.flags</code> attribute defined at extension <code>ruleengineservices</code>. */
	public static final String FLAGS = "flags";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ObjectPatternConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ObjectPatternConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 * @param _flags initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _regexp initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ObjectPatternConstraintModel(final Class _annotation, final Set<RegexpFlag> _flags, final String _id, final String _regexp)
	{
		super();
		setAnnotation(_annotation);
		setFlags(_flags);
		setId(_id);
		setRegexp(_regexp);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 * @param _flags initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _regexp initial attribute declared by type <code>ObjectPatternConstraint</code> at extension <code>ruleengineservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ObjectPatternConstraintModel(final Class _annotation, final Set<RegexpFlag> _flags, final String _id, final ItemModel _owner, final String _regexp)
	{
		super();
		setAnnotation(_annotation);
		setFlags(_flags);
		setId(_id);
		setOwner(_owner);
		setRegexp(_regexp);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ObjectPatternConstraint.flags</code> attribute defined at extension <code>ruleengineservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the flags - Regular expression for constraint
	 */
	@Accessor(qualifier = "flags", type = Accessor.Type.GETTER)
	public Set<RegexpFlag> getFlags()
	{
		return getPersistenceContext().getPropertyValue(FLAGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ObjectPatternConstraint.regexp</code> attribute defined at extension <code>ruleengineservices</code>. 
	 * @return the regexp - Regular expression of toString() Object representation for constraint
	 */
	@Accessor(qualifier = "regexp", type = Accessor.Type.GETTER)
	public String getRegexp()
	{
		return getPersistenceContext().getPropertyValue(REGEXP);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ObjectPatternConstraint.flags</code> attribute defined at extension <code>ruleengineservices</code>. 
	 *  
	 * @param value the flags - Regular expression for constraint
	 */
	@Accessor(qualifier = "flags", type = Accessor.Type.SETTER)
	public void setFlags(final Set<RegexpFlag> value)
	{
		getPersistenceContext().setPropertyValue(FLAGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ObjectPatternConstraint.regexp</code> attribute defined at extension <code>ruleengineservices</code>. 
	 *  
	 * @param value the regexp - Regular expression of toString() Object representation for constraint
	 */
	@Accessor(qualifier = "regexp", type = Accessor.Type.SETTER)
	public void setRegexp(final String value)
	{
		getPersistenceContext().setPropertyValue(REGEXP, value);
	}
	
}
