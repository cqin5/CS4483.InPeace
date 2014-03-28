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
	
	private long runTime = 0;
	
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
	public Integer registerEvent(AbstractEvent event, double secondsUntil) {
		event.setEventID(++lastIssuedID);
		event.setTime(runTime + (long)(1000 * secondsUntil));
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
	public AbstractEvent getMaturedEvent() {
		if (schedule.size() > 0) {
			if (schedule.get(0).getTime().compareTo(runTime) <= 0) {
				return schedule.removeFirst();
			}
		}
		return null;
	}
	
	/**
	 * @param time
	 */
	public void updateRunTime(Long time) {
		runTime = time;
	}
}
