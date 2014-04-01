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
public class RecurringPeriodicEventSeries extends PeriodicEventSeries {
	
	/**   */
	private static final long serialVersionUID = 6270752215495458032L;
	
	/**   */
	private int stopAt;
	private int count;

	/**
	 * Constructs a new RecurringPeriodicEventSeries object.
	 *
	 * @param intervalSeconds
	 * @param actions
	 */
	public RecurringPeriodicEventSeries(double intervalSeconds, int stopAt, AbstractAction[] actions) {
		super(intervalSeconds, actions);
		this.stopAt = stopAt;
		this.count = 0;
	}
	
	/**
	 * Constructs a new RecurringPeriodicEventSeries object.
	 *
	 * @param intervalSeconds
	 * @param actions
	 */
	public RecurringPeriodicEventSeries(double intervalSeconds, AbstractAction[] actions) {
		this(intervalSeconds, 0, actions);
	}

	public void execute() {
		super.execute();
		if (getNext() >= getActions().length) {
			if (stopAt == 0 || count < stopAt) {
				setNext(0);
				Scheduler.getInstance().registerEvent(this, getInterval());
			}
		}
	}

}
