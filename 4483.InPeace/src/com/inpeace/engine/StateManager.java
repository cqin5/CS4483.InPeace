package com.inpeace.engine;

import com.inpeace.states.AbstractState;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   25 Mar 2014
 */
public class StateManager {

	private static StateManager instance = null;
	
	private AbstractState currentState;
	
	private StateManager() {
		currentState = null;
	}
	
	public static StateManager getInstance() {
		if (instance == null) {
			instance = new StateManager();
		}
		return instance;
	}
	
	public AbstractState getCurrentState() {
		return currentState;
	}
}
