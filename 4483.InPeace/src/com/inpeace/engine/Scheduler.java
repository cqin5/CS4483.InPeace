package com.inpeace.engine;

import java.util.ArrayList;

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
	private Integer lastIssuedID;
		
	/**
	 * Constructs a new Scheduler object.
	 *
	 */
	private Scheduler() {
		schedule = new Schedule();
		lastIssuedID = 0;
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
		event.setTime(System.currentTimeMillis() + (long)(1000 * secondsUntil));
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
			if (schedule.get(0).getTime().compareTo(System.currentTimeMillis()) <= 0) {
				return schedule.removeFirst();
			}
		}
		return null;
	}

	/**
	 * 
	 */
	public void executeMaturedEvents() {
		AbstractEvent event = null;
		while ((event = getMaturedEvent()) != null) {
			event.execute();
		}
	}
	
	/**
	 * @return
	 */
	public ArrayList<AbstractEvent> getSnapshot() {
		return schedule.getSnapshot();
	}
	
	/**
	 * @param snapshot
	 */
	public void restoreSnapshot(ArrayList<AbstractEvent> snapshot) {
		schedule.restoreSnapshot(snapshot);
	}
}
