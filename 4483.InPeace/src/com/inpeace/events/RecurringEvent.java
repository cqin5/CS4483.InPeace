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

	/**   */
	private int stopAt;
	private int count;

	/**
	 * Constructs a new AbstractRecurringEvent object.
	 *
	 * @param periodSeconds
	 */
	public RecurringEvent(double periodSeconds, AbstractAction... actions) {
		super(actions);
		this.period = periodSeconds;
		this.stopAt = 0;
		this.count = 0;
	}

	public RecurringEvent(double periodSeconds, int stopAt, AbstractAction... actions) {
		this(periodSeconds, actions);
		this.stopAt = stopAt;
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
		count++;
		if (stopAt == 0 || count < stopAt) {
			Scheduler.getInstance().registerEvent(this, period);
		}
	}

}
