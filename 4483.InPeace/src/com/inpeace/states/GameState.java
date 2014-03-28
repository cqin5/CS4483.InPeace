package com.inpeace.states;

import com.inpeace.engine.StateManager.StateID;



/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class GameState extends AbstractState {

	/**
	 * Constructs a new GameState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public GameState() {
		super(StateType.IN_GAME, StateID.GAME_PLAY, true);
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
