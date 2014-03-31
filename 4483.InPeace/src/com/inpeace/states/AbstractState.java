package com.inpeace.states;

import com.inpeace.engine.StateManager.StateID;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public abstract class AbstractState {
	
	/** State type codes. */
	public static enum StateType {
		NONE, SPLASH, DEFAULT, IN_GAME, OVERLAY
	}

	/**   */
	protected final StateType stateType;
	
	/**   */
	private final StateID id;
	
	/**   */
	private final boolean historical;
	
	/**
	 * Constructs a new AbstractState object.
	 *
	 * @param type
	 * @param id
	 * @param historical
	 */
	public AbstractState(StateType type, StateID id, boolean historical) {
		this.stateType = type;
		this.id = id;
		this.historical = historical;
	}
	
	/**
	 * Get the type
	 *
	 * @return the type
	 */
	public StateType getType() {
		return stateType;
	}

	/**
	 * Get the stateID
	 *
	 * @return the stateID
	 */
	public StateID getStateID() {
		return id;
	}
	
	/**
	 * @return
	 */
	public boolean isHistorical() {
		return historical;
	}
	
	/**
	 * @param graphics
	 * @param audio
	 * @param logic
	 * @param data
	 */
	public abstract void load();
	
	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public abstract void close();
}
