package com.inpeace.actions;



/**
 * 
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
