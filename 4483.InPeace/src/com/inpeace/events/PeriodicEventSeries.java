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
public class PeriodicEventSeries extends AbstractEvent {
	
	/**   */
	private static final long serialVersionUID = 8130076132623092479L;

	/**   */
	private final AbstractAction[] actions;
	
	/**   */
	private final double interval;

	/**   */
	private int next;
	
	/**
	 * Constructs a new PeriodicEventSeries object.
	 *
	 * @param intervalSeconds
	 * @param actions
	 */
	public PeriodicEventSeries(double intervalSeconds, AbstractAction... actions) {
		this.actions = actions;
		this.interval = intervalSeconds;
		this.next = 0;
	}
	
	/**
	 * Get the next
	 *
	 * @return the next
	 */
	public int getNext() {
		return next;
	}

	/**
	 * Set the next
	 *
	 * @param next the next to set
	 */
	public void setNext(int next) {
		this.next = next;
	}

	/**
	 * Get the actions
	 *
	 * @return the actions
	 */
	public AbstractAction[] getActions() {
		return actions;
	}

	/**
	 * Get the interval
	 *
	 * @return the interval
	 */
	public double getInterval() {
		return interval;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.engine.LogicElement#execute()
	 */
	@Override
	public void execute() {
		if (next < actions.length) {
			actions[next++].execute();
		}
		if (next < actions.length) {
			Scheduler.getInstance().registerEvent(this, interval);
		}
	}

}
