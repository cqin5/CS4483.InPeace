package com.inpeace.events;

import com.inpeace.engine.MailRoom;
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
	public ChangeStateEvent(int newStateCode) {
		super();
		this.newStateCode = newStateCode;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#perform(com.inpeace.engine.GameEngine)
	 */
	@Override
	public void execute() {
		MailRoom.getInstance().postRequest(StateManager.LOAD_STATE, newStateCode, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES);
	}

}
