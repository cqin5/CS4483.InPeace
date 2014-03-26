package com.inpeace.events;

import com.inpeace.engine.GameEngine;
import com.inpeace.engine.Request;
import com.inpeace.engine.StateManager;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class ChangeStateEvent extends AbstractEvent {
	
	private final int newStateCode;

	/**
	 * Constructs a new ChangeStateEvent object.
	 *
	 * @param time
	 */
	public ChangeStateEvent(Long time, int newStateCode) {
		super(time);
		this.newStateCode = newStateCode;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#perform(com.inpeace.engine.GameEngine)
	 */
	@Override
	public void execute(GameEngine engine) {
		engine.postRequest(StateManager.LOAD_STATE, newStateCode, Request.CHANGE_PROPERTY_REQUEST,
				Request.ROUTE_TO_STATES);
	}

}
