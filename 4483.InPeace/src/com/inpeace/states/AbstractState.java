package com.inpeace.states;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public abstract class AbstractState {
	
	/** State type codes. */
	public static final int SPLASH_SCREEN = 0;
	public static final int DEFAULT_SCREEN = 1;
	public static final int GAME_SCREEN = 2;
	public static final int OVERLAY_SCREEN = 3;

	/**   */
	protected final int stateType;
	
	/**   */
	private final int stateID;
	
	/**   */
	private final boolean historical;
	
	/**
	 * Constructs a new AbstractState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public AbstractState(int type, int stateID, boolean historical) {
		this.stateType = type;
		this.stateID = stateID;
		this.historical = historical;
	}
	
	/**
	 * Get the type
	 *
	 * @return the type
	 */
	public int getType() {
		return stateType;
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
