package com.inpeace.events;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.Scheduler;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class RecurringEvent extends Event {
	
	/**   */
	private double period;
		
	/**
	 * Constructs a new AbstractRecurringEvent object.
	 *
	 * @param periodSeconds
	 */
	public RecurringEvent(double periodSeconds, AbstractAction... actions) {
		super(actions);
		this.period = periodSeconds;
	}

	/**
	 * Get the period
	 *
	 * @return the period
	 */
	public double getPeriod() {
		return period;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		Scheduler.getInstance().registerEvent(this, period);
	}

}
