package com.inpeace.engine;

import com.inpeace.events.AbstractEvent;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   25 Mar 2014
 */
public class LogicManager {
	
	/**   */
	private Scheduler scheduler;
	
	/**
	 * Constructs a new LogicManager object.
	 *
	 */
	public LogicManager() {
		scheduler = new Scheduler();
	}
	
	/**
	 * @param engine
	 */
	public void executeOfAgeEvents(GameEngine engine) {
		AbstractEvent event = scheduler.getOfAge(engine.getRunTime());
		while (event != null) {
			event.execute(engine);
			event = scheduler.getOfAge(engine.getRunTime());
		}
	}
	
	public void makeChangeRequest(Request request) {
		//TODO
	}
}
