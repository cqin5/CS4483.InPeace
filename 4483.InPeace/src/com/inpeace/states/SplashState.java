package com.inpeace.states;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.engine.Scheduler;
import com.inpeace.engine.StateManager;
import com.inpeace.events.ChangeStateEvent;


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
	
	private static final int duration = 2;  //in seconds
	
	/**
	 * Constructs a new SplashState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public SplashState() {
		super(AbstractState.SPLASH_SCREEN, StateManager.UWO_SPLASH, false);
		// TODO Auto-generated constructor stub
	}

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
	public void load() {
		
		MailRoom.getInstance().postRequest(GraphicsController.BACKGROUND_IMAGE_NAME, graphicName, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_GRAPHICS);
		MailRoom.getInstance().postRequest(StateManager.LOAD_STATE, getStateID(), 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES);
		
		Scheduler.getInstance().registerEvent(new ChangeStateEvent(StateManager.MAIN_MENU), duration);
		 
		// TODO add audio and event to load
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		//NULL BODY
	}

}
