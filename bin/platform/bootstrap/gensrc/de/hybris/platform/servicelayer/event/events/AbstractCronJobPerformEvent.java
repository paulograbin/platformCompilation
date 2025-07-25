/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.event.events;

import java.io.Serializable;

import de.hybris.platform.core.PK;
import de.hybris.platform.servicelayer.event.events.AbstractCronJobEvent;

public abstract  class AbstractCronJobPerformEvent extends AbstractCronJobEvent 
{


	/** <i>Generated property</i> for <code>AbstractCronJobPerformEvent.scheduled</code> property defined at extension <code>processing</code>. */
	
	private boolean scheduled;

	/** <i>Generated property</i> for <code>AbstractCronJobPerformEvent.scheduledByTriggerPk</code> property defined at extension <code>processing</code>. */
	
	private PK scheduledByTriggerPk;

	/** <i>Generated property</i> for <code>AbstractCronJobPerformEvent.synchronous</code> property defined at extension <code>processing</code>. */
	
	private boolean synchronous;
	
	public AbstractCronJobPerformEvent()
	{
		super();
	}

	public AbstractCronJobPerformEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setScheduled(final boolean scheduled)
	{
		this.scheduled = scheduled;
	}

	public boolean isScheduled() 
	{
		return scheduled;
	}
	
	public void setScheduledByTriggerPk(final PK scheduledByTriggerPk)
	{
		this.scheduledByTriggerPk = scheduledByTriggerPk;
	}

	public PK getScheduledByTriggerPk() 
	{
		return scheduledByTriggerPk;
	}
	
	public void setSynchronous(final boolean synchronous)
	{
		this.synchronous = synchronous;
	}

	public boolean isSynchronous() 
	{
		return synchronous;
	}
	


}
