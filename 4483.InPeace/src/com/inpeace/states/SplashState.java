package com.inpeace.states;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.GameEngine;
import com.inpeace.engine.Request;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class SplashState extends AbstractState {
	
	/**
	 * Constructs a new SplashState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public SplashState() {
		super(0, 0, false);
		// TODO Auto-generated constructor stub
	}

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
	public void load(GameEngine engine) {
		
		engine.postRequest(new Request(GraphicsController.BACKGROUND_IMAGE_NAME, graphicName, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_GRAPHICS));
		
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

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#initialiseGraphicsModels()
	 */
	@Override
	public void initialiseGraphicsModels() {
		// TODO Auto-generated method stub
		
	}

}
