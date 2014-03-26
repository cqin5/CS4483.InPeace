package com.inpeace.engine;

import com.inpeace.events.AbstractEvent;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class Scheduler {
	
	/**   */
	public static final String SCHEDULED_EVENT = "Event";

	/**   */
	private final Schedule schedule;
	
	/**   */
	private Integer lastIssuedID = 0;
	
	/**
	 * Constructs a new Scheduler object.
	 *
	 */
	public Scheduler() {
		this.schedule = new Schedule();
	}
	
	/**
	 * @param event
	 */
	public Integer setEvent(AbstractEvent event) {
		event.setEventID(++lastIssuedID);
		schedule.add(event);
		return lastIssuedID;
	}
	
	/**
	 * @param eventID
	 */
	public void clearEvent(Integer eventID) {
		schedule.remove(eventID);
	}
	
	/**
	 * @param time
	 * @return
	 */
	public AbstractEvent getOfAge(Long time) {
		if (schedule.size() > 0) {
			if (schedule.get(0).getTime() <= time) {
				return schedule.remove(0);
			}
		}
		return null;
	}
}
