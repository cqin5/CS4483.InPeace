package com.inpeace.states;

import com.inpeace.engine.DataManager;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.Scheduler;
import com.inpeace.engine.StateManager.StateID;
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
		super(StateType.SPLASH, StateID.UWO_SPLASH, false);
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
		
		DefaultGraphicsModel graphicModel = new DefaultGraphicsModel();
		
		graphicModel.setBackgroundName(graphicName);
		
		MailRoom.getInstance().postRequest(DataManager.DEFAULT_GRAPHICS_MODEL, graphicModel, 
				RequestType.REGISTER);
		
		AudioModel audioModel = new AudioModel();
		audioModel.setMusicName("elevator");
		MailRoom.getInstance().postRequest(DataManager.AUDIO_MODEL, audioModel, 
				RequestType.REGISTER);
		
		Scheduler.getInstance().registerEvent(new ChangeStateEvent(StateID.MAIN_MENU), duration);

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
