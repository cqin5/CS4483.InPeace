package com.inpeace.states;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.AudioManager;
import com.inpeace.engine.DataManager;
import com.inpeace.engine.GraphicsManager;
import com.inpeace.engine.LogicManager;
import com.inpeace.engine.Request;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class SplashState extends AbstractState {
	
	/**   */
	private static final String graphicName = "splash";

	/**
	 * Get the graphicName
	 *
	 * @return the graphicName
	 */
	public String getGraphicName() {
		return graphicName;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#load(com.inpeace.engine.GraphicsManager, com.inpeace.engine.AudioManager, com.inpeace.engine.LogicManager, com.inpeace.engine.DataManager)
	 */
	@Override
	public void load(GraphicsManager graphics, AudioManager audio,
			LogicManager logic, DataManager data) {
		
		graphics.makeChangeRequest(new Request(GraphicsController.BACKGROUND_IMAGE_NAME, graphicName, 
				Request.CHANGE_PROPERTY_REQUEST));
		
		// TODO add audio and logic (ie. timer action) to load
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		//NULL BODY
		
	}

}
