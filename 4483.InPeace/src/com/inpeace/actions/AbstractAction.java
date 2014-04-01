package com.inpeace.actions;

import java.io.Serializable;

import com.inpeace.engine.LogicElement;



/**
 * The extendible superclass of all actions.  Extend this class directly for actions that only post
 * requests to the game engine, and do not need to directly affect the entity to which they are
 * attached.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public abstract class AbstractAction implements LogicElement, Serializable {
	
	/**   */
	private static final long serialVersionUID = 8313239751623656863L;
	
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
	
}
