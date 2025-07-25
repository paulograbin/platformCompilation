/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.workflow.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type AbstractWorkflowDecision first defined at extension workflow.
 */
@SuppressWarnings("all")
public class AbstractWorkflowDecisionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractWorkflowDecision";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.code</code> attribute defined at extension <code>workflow</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.name</code> attribute defined at extension <code>workflow</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.description</code> attribute defined at extension <code>workflow</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.visualisationX</code> attribute defined at extension <code>backoffice</code>. */
	public static final String VISUALISATIONX = "visualisationX";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.visualisationY</code> attribute defined at extension <code>backoffice</code>. */
	public static final String VISUALISATIONY = "visualisationY";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractWorkflowDecision.qualifier</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String QUALIFIER = "qualifier";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractWorkflowDecisionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractWorkflowDecisionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractWorkflowDecision</code> at extension <code>workflow</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractWorkflowDecisionModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.code</code> attribute defined at extension <code>workflow</code>. 
	 * @return the code - unique identifier of the decision
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.description</code> attribute defined at extension <code>workflow</code>. 
	 * @return the description - description of the decision
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getDescription(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.description</code> attribute defined at extension <code>workflow</code>. 
	 * @param loc the value localization key 
	 * @return the description - description of the decision
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(DESCRIPTION, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.name</code> attribute defined at extension <code>workflow</code>. 
	 * @return the name - name of the decision
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.name</code> attribute defined at extension <code>workflow</code>. 
	 * @param loc the value localization key 
	 * @return the name - name of the decision
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.qualifier</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the qualifier - Used to qualify a Desicion by name
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.GETTER)
	public String getQualifier()
	{
		return getPersistenceContext().getPropertyValue(QUALIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.visualisationX</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the visualisationX
	 */
	@Accessor(qualifier = "visualisationX", type = Accessor.Type.GETTER)
	public Integer getVisualisationX()
	{
		return getPersistenceContext().getPropertyValue(VISUALISATIONX);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractWorkflowDecision.visualisationY</code> attribute defined at extension <code>backoffice</code>. 
	 * @return the visualisationY
	 */
	@Accessor(qualifier = "visualisationY", type = Accessor.Type.GETTER)
	public Integer getVisualisationY()
	{
		return getPersistenceContext().getPropertyValue(VISUALISATIONY);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AbstractWorkflowDecision.code</code> attribute defined at extension <code>workflow</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code - unique identifier of the decision
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.description</code> attribute defined at extension <code>workflow</code>. 
	 *  
	 * @param value the description - description of the decision
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		setDescription(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.description</code> attribute defined at extension <code>workflow</code>. 
	 *  
	 * @param value the description - description of the decision
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(DESCRIPTION, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.name</code> attribute defined at extension <code>workflow</code>. 
	 *  
	 * @param value the name - name of the decision
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.name</code> attribute defined at extension <code>workflow</code>. 
	 *  
	 * @param value the name - name of the decision
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.qualifier</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the qualifier - Used to qualify a Desicion by name
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.SETTER)
	public void setQualifier(final String value)
	{
		getPersistenceContext().setPropertyValue(QUALIFIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.visualisationX</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the visualisationX
	 */
	@Accessor(qualifier = "visualisationX", type = Accessor.Type.SETTER)
	public void setVisualisationX(final Integer value)
	{
		getPersistenceContext().setPropertyValue(VISUALISATIONX, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractWorkflowDecision.visualisationY</code> attribute defined at extension <code>backoffice</code>. 
	 *  
	 * @param value the visualisationY
	 */
	@Accessor(qualifier = "visualisationY", type = Accessor.Type.SETTER)
	public void setVisualisationY(final Integer value)
	{
		getPersistenceContext().setPropertyValue(VISUALISATIONY, value);
	}
	
}
