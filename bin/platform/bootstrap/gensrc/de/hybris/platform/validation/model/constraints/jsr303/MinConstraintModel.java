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
import de.hybris.platform.validation.model.constraints.AttributeConstraintModel;

/**
 * Generated model class for type MinConstraint first defined at extension validation.
 * <p>
 * Minimal JSR 303 compatible constraint class.
 */
@SuppressWarnings("all")
public class MinConstraintModel extends AttributeConstraintModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MinConstraint";
	
	/** <i>Generated constant</i> - Attribute key of <code>MinConstraint.value</code> attribute defined at extension <code>validation</code>. */
	public static final String VALUE = "value";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MinConstraintModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MinConstraintModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>MinConstraint</code> at extension <code>validation</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _value initial attribute declared by type <code>MinConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MinConstraintModel(final Class _annotation, final String _id, final Long _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setValue(_value);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _annotation initial attribute declared by type <code>MinConstraint</code> at extension <code>validation</code>
	 * @param _id initial attribute declared by type <code>AbstractConstraint</code> at extension <code>validation</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _value initial attribute declared by type <code>MinConstraint</code> at extension <code>validation</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MinConstraintModel(final Class _annotation, final String _id, final ItemModel _owner, final Long _value)
	{
		super();
		setAnnotation(_annotation);
		setId(_id);
		setOwner(_owner);
		setValue(_value);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MinConstraint.value</code> attribute defined at extension <code>validation</code>. 
	 * @return the value - Minimal value
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.GETTER)
	public Long getValue()
	{
		return getPersistenceContext().getPropertyValue(VALUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MinConstraint.value</code> attribute defined at extension <code>validation</code>. 
	 *  
	 * @param value the value - Minimal value
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.SETTER)
	public void setValue(final Long value)
	{
		getPersistenceContext().setPropertyValue(VALUE, value);
	}
	
}
