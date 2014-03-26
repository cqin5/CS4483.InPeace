package com.inpeace.states;

import com.inpeace.engine.GameEngine;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class MainMenuState extends AbstractState {

	/**   */
	private final String backgroundName;
	
	/**   */
	private String[] buttonSpriteCodes;
	
	/**
	 * Constructs a new MainMenuState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public MainMenuState() {
		super(0, 0, false);
		backgroundName = "main";
		buttonSpriteCodes[0] =  "";
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the buttonSpriteCodes
	 *
	 * @return the buttonSpriteCodes
	 */
	public String[] getButtonSpriteCodes() {
		return buttonSpriteCodes;
	}

	/**
	 * Set the buttonSpriteCodes
	 *
	 * @param buttonSpriteCodes the buttonSpriteCodes to set
	 */
	public void setButtonSpriteCodes(String[] buttonSpriteCodes) {
		this.buttonSpriteCodes = buttonSpriteCodes;
	}

	/**
	 * Get the backgroundName
	 *
	 * @return the backgroundName
	 */
	public String getBackgroundName() {
		return backgroundName;
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
