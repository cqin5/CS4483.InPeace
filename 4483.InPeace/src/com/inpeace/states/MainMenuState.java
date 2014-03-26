package com.inpeace.states;

import com.inpeace.engine.AudioManager;
import com.inpeace.engine.DataManager;
import com.inpeace.engine.GraphicsManager;
import com.inpeace.engine.LogicManager;


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

	/**
	 * Constructs a new MainMenuState object.
	 *
	 */
	public MainMenuState() {
		backgroundName = "main";
		buttonSpriteCodes[0] =  "";
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#load(com.inpeace.engine.GraphicsManager, com.inpeace.engine.AudioManager, com.inpeace.engine.LogicManager, com.inpeace.engine.DataManager)
	 */
	@Override
	public void load(GraphicsManager graphics, AudioManager audio,
			LogicManager logic, DataManager data) {
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
	
}
