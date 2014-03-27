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
	
	/**
	 * Constructs a new LogicManager object.
	 *
	 */
	public LogicManager() {
		//TODO
	}
	
	/**
	 * @param engine
	 */
	public void executeMaturedEvents(GameEngine engine) {
		AbstractEvent event = Scheduler.getInstance().getMaturedEvent(engine.getRunTime());
		while (event != null) {
			event.execute(engine);
			event = Scheduler.getInstance().getMaturedEvent(engine.getRunTime());
		}
	}
	
	public void makeChangeRequest(Request request) {
		//TODO
	}
}
