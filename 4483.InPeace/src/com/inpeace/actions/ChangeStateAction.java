package com.inpeace.actions;

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
 * @since   24 Mar 2014
 */
public class ChangeStateAction extends AbstractAction {

	/**   */
	private StateID newID;
	
	/**
	 * Constructs a new CollectAction object.
	 *
	 * @param item
	 */
	public ChangeStateAction(StateID newID) {
		this.newID = newID;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.actions.Action#performAction()
	 */
	@Override
	public void performAction() {
		MailRoom.getInstance().postRequest(StateManager.STATE, newID, 
				RequestType.CHANGE_PROPERTY, RouteTo.STATES);
		
	}

}
