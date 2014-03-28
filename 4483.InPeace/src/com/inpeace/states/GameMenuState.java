package com.inpeace.states;

import com.inpeace.engine.StateManager.StateID;



/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class GameMenuState extends AbstractState {

	/**
	 * Constructs a new GameMenuState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public GameMenuState() {
		super(StateType.DEFAULT, StateID.GAME_MENU, true);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#load(com.inpeace.engine.GraphicsManager, com.inpeace.engine.AudioManager, com.inpeace.engine.LogicManager, com.inpeace.engine.DataManager)
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
