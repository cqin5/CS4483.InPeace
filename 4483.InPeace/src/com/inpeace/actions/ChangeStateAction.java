package com.inpeace.actions;

import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.engine.StateManager;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ChangeStateAction extends AbstractAction {

	/**   */
	private int stateID;
	
	/**
	 * Constructs a new CollectAction object.
	 *
	 * @param item
	 */
	public ChangeStateAction(int stateID) {
		this.stateID = stateID;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.actions.Action#performAction()
	 */
	@Override
	public void performAction() {
		MailRoom.getInstance().postRequest(StateManager.LOAD_STATE, stateID, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES);
		
	}

}
