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
	
	private static Scheduler instance = null;

	/**   */
	private final Schedule schedule;
	
	/**   */
	private Integer lastIssuedID = 0;
	
	/**
	 * Constructs a new Scheduler object.
	 *
	 */
	private Scheduler() {
		this.schedule = new Schedule();
	}
	
	/**
	 * @return
	 */
	public static Scheduler getInstance() {
		if (instance == null) {
			instance = new Scheduler();
		}
		return instance;
	}
	
	/**
	 * @param event
	 */
	public Integer registerEvent(AbstractEvent event) {
		event.setEventID(++lastIssuedID);
		schedule.add(event);
		return lastIssuedID;
	}
	
	/**
	 * @param eventID
	 */
	public void deregisterEvent(Integer eventID) {
		schedule.remove(eventID);
	}
	
	/**
	 * @param time
	 * @return
	 */
	public AbstractEvent getMaturedEvent(Long time) {
		if (schedule.size() > 0) {
			if (schedule.get(0).getTime() <= time) {
				return schedule.remove(0);
			}
		}
		return null;
	}
}
