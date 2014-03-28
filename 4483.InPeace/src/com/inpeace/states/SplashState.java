package com.inpeace.states;

import com.inpeace.controllers.DefaultController;
import com.inpeace.engine.DataManager;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.engine.Scheduler;
import com.inpeace.engine.StateManager;
import com.inpeace.events.ChangeStateEvent;
import com.inpeace.models.AudioModel;
import com.inpeace.models.DefaultGraphicsModel;


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
		
		DefaultGraphicsModel model = new DefaultGraphicsModel();
		
		model.setBackgroundName(graphicName);
		
		MailRoom.getInstance().postRequest(DataManager.DEFAULT_GRAPHICS_MODEL, model, 
				Request.REGISTRATION_REQUEST);
		MailRoom.getInstance().postRequest(DataManager.AUDIO_MODEL, new AudioModel(), 
				Request.REGISTRATION_REQUEST);
		MailRoom.getInstance().postRequest(DefaultController.SOUND_EFFECT, "woow");
		
		Scheduler.getInstance().registerEvent(new ChangeStateEvent(StateManager.MAIN_MENU), duration);

		// TODO add audio model
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		//NULL BODY
	}

}
