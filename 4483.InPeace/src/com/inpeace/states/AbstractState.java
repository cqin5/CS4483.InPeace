package com.inpeace.states;

import com.inpeace.engine.GameEngine;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.HUDGraphicsModel;
import com.inpeace.models.OverlayGraphicsModel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public abstract class AbstractState {

	/**   */
	private final int type;
	
	/**   */
	private final int stateID;
	
	/**   */
	private final boolean historical;
	
	/**   */
	protected final DefaultGraphicsModel defaultGraphics;
	protected final HUDGraphicsModel hudGraphics;
	protected final OverlayGraphicsModel overlayGraphics;
	
	/**
	 * Constructs a new AbstractState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public AbstractState(int type, int stateID, boolean historical) {
		this.type = type;
		this.stateID = stateID;
		this.historical = historical;
		defaultGraphics = new DefaultGraphicsModel();
		hudGraphics = new HUDGraphicsModel();
		overlayGraphics = new OverlayGraphicsModel();
		initialiseGraphicsModels();
	}
	
	/**
	 * Get the type
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
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
	 * 
	 */
	public abstract void initialiseGraphicsModels();
	
	/**
	 * @param graphics
	 * @param audio
	 * @param logic
	 * @param data
	 */
	public abstract void load(GameEngine engine);
	
	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public abstract void close();
}
