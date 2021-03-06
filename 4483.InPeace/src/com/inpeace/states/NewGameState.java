package com.inpeace.states;

import com.inpeace.engine.StateManager.StateID;
import com.inpeace.levels.Level1Basement;



/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class NewGameState extends AbstractState {

	/**
	 * Constructs a new NewGameState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public NewGameState() {
		super(StateType.DEFAULT, StateID.NEW_GAME, false);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#load(com.inpeace.engine.GraphicsManager, com.inpeace.engine.AudioManager, com.inpeace.engine.LogicManager, com.inpeace.engine.DataManager)
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub
		Level1Basement level1 = new Level1Basement();
		level1.load();
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
