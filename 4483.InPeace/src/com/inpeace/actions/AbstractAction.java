package com.inpeace.actions;



/**
 * The extendible superclass of all actions.  Extend this class directly for actions that only post
 * requests to the game engine, and do not need to directly effect the entity to which they are
 * attached.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public abstract class AbstractAction {
	
	/**   */
	private Integer actionID = 0;

	/**
	 * Get the actionID
	 *
	 * @return the actionID
	 */
	public Integer getActionID() {
		return actionID;
	}

	/**
	 * Set the actionID
	 *
	 * @param actionID the actionID to set
	 */
	public void setActionID(Integer actionID) {
		this.actionID = actionID;
	}
	
	/**
	 * 
	 */
	public abstract void performAction();
	
}
