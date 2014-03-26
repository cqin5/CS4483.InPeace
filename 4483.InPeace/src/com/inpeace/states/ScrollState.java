package com.inpeace.states;

import java.util.ArrayList;

import com.inpeace.engine.GameEngine;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class ScrollState extends AbstractState {

	/**
	 * Constructs a new ScrollState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public ScrollState() {
		super(0, 0, false);
		// TODO Auto-generated constructor stub
	}

	/**   */
	private ArrayList<String> lines;

	/**
	 * Get the lines
	 *
	 * @return the lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}

	/**
	 * Set the lines
	 *
	 * @param lines the lines to set
	 */
	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#load(com.inpeace.engine.GraphicsManager, com.inpeace.engine.AudioManager, com.inpeace.engine.LogicManager, com.inpeace.engine.DataManager)
	 */
	@Override
	public void load(GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#initialiseGraphicsModels()
	 */
	@Override
	public void initialiseGraphicsModels() {
		// TODO Auto-generated method stub
		
	}
	
}
