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

	/**
	 * Constructs a new RecurringPeriodicEventSeries object.
	 *
	 * @param intervalSeconds
	 * @param actions
	 */
	public RecurringPeriodicEventSeries(double intervalSeconds, AbstractAction[] actions) {
		super(intervalSeconds, actions);
	}
	
	public void execute() {
		super.execute();
		if (getNext() >= getActions().length) {
			setNext(0);
			Scheduler.getInstance().registerEvent(this, getInterval());
		}
	}

}
