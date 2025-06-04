/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bpunchoutocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation transaction info of an order, containing the target url to submit cXML order message
            and base64 encode order info.
        
 */
@Schema(name="RequisitionFormData", description="Representation transaction info of an order, containing the target url to submit cXML order message and base64 encode order info.")
public  class RequisitionFormDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The url used to submit order into procurement system<br/><br/><i>Generated property</i> for <code>RequisitionFormDataWsDTO.browseFormPostUrl</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="browseFormPostUrl", description="The url used to submit order into procurement system", required=true, example="https://s1.ariba.com/Buyer/punchout?client=HTML.D6040B280216D0CAD6AF0F349AB37943.Node2app823snv&responseid=k&locale=en_US") 	
	private String browseFormPostUrl;

	/** Order info in base64 encoded cXML format, to submit this to procurement system, you must name
                this field with name cxml-base64 or cxml-urlencoded.
            <br/><br/><i>Generated property</i> for <code>RequisitionFormDataWsDTO.orderAsCXML</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="orderAsCXML", description="Order info in base64 encoded cXML format, to submit this to procurement system, you must name this field with name cxml-base64 or cxml-urlencoded.", required=true, example="PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48IURPQ1RZUEUgY1hNTCBTWVNURU0gImh0dHA6Ly94bWwuY1hNTC5vcmcvc2NoZW1hcy9jWE1MLzEuMi4wNTEvY1hNTC5kdGQiPjxjWE1MIHBheWxvYWRJRD0iMTY1NzE4MDA2NjgxOC4xNDc3QEZZRDRNTjdIMFEiIHRpbWVzdGFtcD0iMjAyMi0wNy0wN1QxNTo0Nzo0NiswODowMCIgeG1sOmxhbmc9ImVuLVVTIj48SGVhZGVyPjxGcm9tPjxDcmVkZW50aWFsIGRvbWFpbj0iYnV5ZXJzeXN0ZW1pZCI+PElkZW50aXR5PnAycF9waXR0PC9JZGVudGl0eT48L0NyZWRlbnRpYWw+PENyZWRlbnRpYWwgZG9tYWluPSJpbnRlcm5hbHN1cHBsaWVyaWQiPjxJZGVudGl0eT5wMnBfcGl0dDwvSWRlbnRpdHk+PC9DcmVkZW50aWFsPjxDcmVkZW50aWFsIGRvbWFpbj0iZHVucyI+PElkZW50aXR5PjI0MjQyNDI0dC10PC9JZGVudGl0eT48L0NyZWRlbnRpYWw+PENyZWRlbnRpYWwgZG9tYWluPSJtYXhpbW8iPjxJZGVudGl0eT4zMDc2OTIwPC9JZGVudGl0eT48L0NyZWRlbnRpYWw+PENyZWRlbnRpYWwgZG9tYWluPSJuZXR3b3JraWQiPjxJZGVudGl0eT5hbjAxNjY1NjMyMDU0LXQ8L0lkZW50aXR5PjwvQ3JlZGVudGlhbD48Q3JlZGVudGlhbCBkb21haW49InRyYW5zYWN0aW9ubmV0d29ya2lkIj48SWRlbnRpdHk+YW4wMTY2NTYzMjA1NC10PC9JZGVudGl0eT48L0NyZWRlbnRpYWw+PC9Gcm9tPjxUbz48Q3JlZGVudGlhbCBkb21haW49IkRVTlMiPjxJZGVudGl0eT4xMjM0NTY3ODk8L0lkZW50aXR5PjwvQ3JlZGVudGlhbD48L1RvPjxTZW5kZXI+PENyZWRlbnRpYWwgZG9tYWluPSJBcmliYU5ldHdvcmtVc2VySWQiPjxJZGVudGl0eT5zeXNhZG1pbkBhcmliYS5jb208L0lkZW50aXR5PjwvQ3JlZGVudGlhbD48VXNlckFnZW50PkJ1eWVyIDE0czI8L1VzZXJBZ2VudD48L1NlbmRlcj48L0hlYWRlcj48TWVzc2FnZT48UHVuY2hPdXRPcmRlck1lc3NhZ2U+PEJ1eWVyQ29va2llPkx3VDZuZkZRbk92ZWpFS25EWnlkS3REbkczZnE1ZmVzMC4yNDUwODQyMDU0NDIxMzg4MjMyPC9CdXllckNvb2tpZT48UHVuY2hPdXRPcmRlck1lc3NhZ2VIZWFkZXIgb3BlcmF0aW9uQWxsb3dlZD0iZWRpdCI+PFRvdGFsPjxNb25leSBjdXJyZW5jeT0iVVNEIj40OC4wPC9Nb25leT48L1RvdGFsPjwvUHVuY2hPdXRPcmRlck1lc3NhZ2VIZWFkZXI+PEl0ZW1JbiBxdWFudGl0eT0iMSI+PEl0ZW1JRD48U3VwcGxpZXJQYXJ0SUQ+Mzc1NTIxOTwvU3VwcGxpZXJQYXJ0SUQ+PC9JdGVtSUQ+PEl0ZW1EZXRhaWw+PFVuaXRQcmljZT48TW9uZXkgY3VycmVuY3k9IlVTRCI+NDguMDwvTW9uZXk+PC9Vbml0UHJpY2U+PERlc2NyaXB0aW9uIHhtbDpsYW5nPSJlbiI+Jmx0O2ImZ3Q7Q29tcGFjdCBhbmQgcG93ZXJmdWwgZm9yIGFsbCBzY3Jld2RyaXZpbmcgd29yayDigJMgd2l0aCBkcmlsbCBzZXR0aW5nJmx0Oy9iJmd0OyZsdDtici8mZ3Q7Jmx0O2JyLyZndDsgICAgKiBQb3dlcmZ1bCA5LjYgViBtb3RvciB3aXRoIHBsYW5ldGFyeSBnZWFycy4mbHQ7YnIvJmd0OyAgICAqIFRvcnF1ZSBwcmUtc2VsZWN0aW9uIHdpdGggNSB0b3JxdWUgc2V0dGluZ3MgcGx1cyBhIGRyaWxsIHNldHRpbmcg4oCTIG9wdGltdW0gcG93ZXIgZm9yIGV2ZXJ5IGFwcGxpY2F0aW9uLiZsdDtici8mZ3Q7ICAgICogVHdpbi1zbGVldmUga2V5bGVzcyBjaHVjayDigJMgZWFzeSwgdG9vbC1mcmVlIGJpdCBjaGFuZ2VzLiZsdDtici8mZ3Q7ICAgICogQm9zY2ggRWxlY3Ryb25pYyBzcGVlZCBjb250cm9sOiAiYWNjZWxlcmF0ZSIgZnJvbSAwIOKAkyBtYXguIHVzaW5nIHRoZSB0cmlnZ2VyIHN3aXRjaC4mbHQ7YnIvJmd0OyAgICAqIFNvZnRncmlwIGZvciBhIGJldHRlciBhbmQgbW9yZSBjb21mb3J0YWJsZSBob2xkLiZsdDtici8mZ3Q7ICAgICogUnVuLW91dCBicmFrZSBhbmQgc3dpdGNoLW9uIGxvY2suJmx0O2JyLyZndDsgICAgKiBRdWljay1jaGFuZ2UgYmF0dGVyeSBwYWNrLiZsdDtici8mZ3Q7ICAgICogQml0IHN0b3JhZ2UgY29tcGFydG1lbnQgb24gdGhlIGhvdXNpbmcuPC9EZXNjcmlwdGlvbj48VW5pdE9mTWVhc3VyZT5DNjI8L1VuaXRPZk1lYXN1cmU+PENsYXNzaWZpY2F0aW9uIGRvbWFpbj0iVU5TUFNDIj4yMzI5MTUwMDwvQ2xhc3NpZmljYXRpb24+PC9JdGVtRGV0YWlsPjwvSXRlbUluPjwvUHVuY2hPdXRPcmRlck1lc3NhZ2U+PC9NZXNzYWdlPjwvY1hNTD4=") 	
	private String orderAsCXML;
	
	public RequisitionFormDataWsDTO()
	{
		// default constructor
	}
	
	public void setBrowseFormPostUrl(final String browseFormPostUrl)
	{
		this.browseFormPostUrl = browseFormPostUrl;
	}

	public String getBrowseFormPostUrl() 
	{
		return browseFormPostUrl;
	}
	
	public void setOrderAsCXML(final String orderAsCXML)
	{
		this.orderAsCXML = orderAsCXML;
	}

	public String getOrderAsCXML() 
	{
		return orderAsCXML;
	}
	

}