package com.inpeace.events;

import com.inpeace.engine.Scheduler;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public abstract class RecurringEvent extends AbstractEvent {
	
	/**   */
	private double period;
	
	/**   */
	private AbstractEvent event;
	
	/**
	 * Constructs a new AbstractRecurringEvent object.
	 *
	 * @param recurrancePeriodSeconds
	 */
	public RecurringEvent(double recurrancePeriodSeconds, AbstractEvent event) {
		this.period = recurrancePeriodSeconds;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#execute()
	 */
	@Override
	public void execute() {
		event.execute();
		Scheduler.getInstance().registerEvent(this, period);
	}

}
