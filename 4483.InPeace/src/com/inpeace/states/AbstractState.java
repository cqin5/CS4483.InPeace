package com.inpeace.states;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   24 Mar 2014
 */
public abstract class AbstractState {

	/**   */
	private int type; //0 = splash, 1 = menu, 2 = in game, 3 = overlay
	
	/**   */
	private int stateID;
	
	/**   */
	private int scrollPostion;
	
	/**   */
	private String backgroundName;
	
	/**
	 * @return
	 */
	public abstract boolean isHistorical();
	
	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public abstract void close();

	/**
	 * Get the type
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Set the type
	 *
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Get the stateID
	 *
	 * @return the stateID
	 */
	public int getStateID() {
		return stateID;
	}

	/**
	 * Set the stateID
	 *
	 * @param stateID the stateID to set
	 */
	public void setStateID(int stateID) {
		this.stateID = stateID;
	}
	
	/**
	 * @return
	 */
	public int getScrollPosition() {
		return scrollPostion;
	}
	
	public String getBackgroundName() {
		return backgroundName;
	}
	
}
