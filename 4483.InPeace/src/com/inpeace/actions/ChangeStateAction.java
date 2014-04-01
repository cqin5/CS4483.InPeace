package com.inpeace.actions;

import com.inpeace.engine.StateManager;
import com.inpeace.engine.StateManager.StateID;
import com.inpeace.exceptions.StateException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ChangeStateAction extends AbstractAction {

	/**   */
	private static final long serialVersionUID = 5615058738363842034L;
	
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
	public void execute() {
		try {
			StateManager.getInstance().changeState(newID);
		} catch (StateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
