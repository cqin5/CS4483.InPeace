package com.inpeace.events;

import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.Request.RouteTo;
import com.inpeace.engine.StateManager;
import com.inpeace.engine.StateManager.StateID;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class ChangeStateEvent extends AbstractEvent {
	
	private final StateID newID;

	/**
	 * Constructs a new ChangeStateEvent object.
	 *
	 * @param time
	 */
	public ChangeStateEvent(StateID newID) {
		super();
		this.newID = newID;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#perform(com.inpeace.engine.GameEngine)
	 */
	@Override
	public void execute() {
		MailRoom.getInstance().postRequest(StateManager.STATE, newID, 
				RequestType.CHANGE_PROPERTY, RouteTo.STATES);
	}

}
