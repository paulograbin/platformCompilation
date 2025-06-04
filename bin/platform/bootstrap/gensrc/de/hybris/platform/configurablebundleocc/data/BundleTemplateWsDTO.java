/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleocc.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Description of a bundle component related to a product
 */
@Schema(name="BundleTemplate", description="Description of a bundle component related to a product")
public  class BundleTemplateWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Id of this bundle template<br/><br/><i>Generated property</i> for <code>BundleTemplateWsDTO.id</code> property defined at extension <code>configurablebundleocc</code>. */
@Schema(name="id", description="Id of this bundle template", required=true, example="PhotoOTGCameraComponent") 	
	private String id;

	/** Name of this bundle template<br/><br/><i>Generated property</i> for <code>BundleTemplateWsDTO.name</code> property defined at extension <code>configurablebundleocc</code>. */
@Schema(name="name", description="Name of this bundle template", required=false, example="Camera Component") 	
	private String name;

	/** Name of the root bundle template within the bundle tree structure<br/><br/><i>Generated property</i> for <code>BundleTemplateWsDTO.rootBundleTemplateName</code> property defined at extension <code>configurablebundleocc</code>. */
@Schema(name="rootBundleTemplateName", description="Name of the root bundle template within the bundle tree structure", required=false, example="Photo On The Go Package") 	
	private String rootBundleTemplateName;
	
	public BundleTemplateWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setRootBundleTemplateName(final String rootBundleTemplateName)
	{
		this.rootBundleTemplateName = rootBundleTemplateName;
	}

	public String getRootBundleTemplateName() 
	{
		return rootBundleTemplateName;
	}
	

}