/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;


import java.util.Objects;
public  class SolrClientConfig  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SolrClientConfig.aliveCheckInterval</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private Integer aliveCheckInterval;

	/** <i>Generated property</i> for <code>SolrClientConfig.connectionTimeout</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private Integer connectionTimeout;

	/** <i>Generated property</i> for <code>SolrClientConfig.socketTimeout</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private Integer socketTimeout;

	/** <i>Generated property</i> for <code>SolrClientConfig.maxConnections</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private Integer maxConnections;

	/** <i>Generated property</i> for <code>SolrClientConfig.maxConnectionsPerHost</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private Integer maxConnectionsPerHost;

	/** <i>Generated property</i> for <code>SolrClientConfig.tcpNoDelay</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private boolean tcpNoDelay;

	/** <i>Generated property</i> for <code>SolrClientConfig.username</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private String username;

	/** <i>Generated property</i> for <code>SolrClientConfig.password</code> property defined at extension <code>solrfacetsearch</code>. */
	
	private String password;
	
	public SolrClientConfig()
	{
		// default constructor
	}
	
	public void setAliveCheckInterval(final Integer aliveCheckInterval)
	{
		this.aliveCheckInterval = aliveCheckInterval;
	}

	public Integer getAliveCheckInterval() 
	{
		return aliveCheckInterval;
	}
	
	public void setConnectionTimeout(final Integer connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}

	public Integer getConnectionTimeout() 
	{
		return connectionTimeout;
	}
	
	public void setSocketTimeout(final Integer socketTimeout)
	{
		this.socketTimeout = socketTimeout;
	}

	public Integer getSocketTimeout() 
	{
		return socketTimeout;
	}
	
	public void setMaxConnections(final Integer maxConnections)
	{
		this.maxConnections = maxConnections;
	}

	public Integer getMaxConnections() 
	{
		return maxConnections;
	}
	
	public void setMaxConnectionsPerHost(final Integer maxConnectionsPerHost)
	{
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

	public Integer getMaxConnectionsPerHost() 
	{
		return maxConnectionsPerHost;
	}
	
	public void setTcpNoDelay(final boolean tcpNoDelay)
	{
		this.tcpNoDelay = tcpNoDelay;
	}

	public boolean isTcpNoDelay() 
	{
		return tcpNoDelay;
	}
	
	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	

}