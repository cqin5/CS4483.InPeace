 package com.inpeace.states;

import java.awt.Point;

import com.inpeace.actions.ChangeStateAction;
import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.engine.StateManager;
import com.inpeace.entities.ImageEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class MainMenuState extends AbstractState {

	/**   */
	private static final String backgroundName = "test";
	
	/**   */
	private static final String[] buttonSpriteCodes =  null;
	
	/**
	 * Constructs a new MainMenuState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public MainMenuState() {
		super(AbstractState.DEFAULT_SCREEN, StateManager.MAIN_MENU, true);
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
	public void load() {
		
		MailRoom.getInstance().postRequest(GraphicsController.BACKGROUND_IMAGE_NAME, backgroundName, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_GRAPHICS);
		
		ImageEntity entity = new ImageEntity(1, new ChangeStateAction(StateManager.SCROLL), null, 
				"1-0-0-128-128", "1-0-128-128-128", "1-0-256-128-128", new Point(0,0));
		MailRoom.getInstance().postRequest(GraphicsController.FOREGROUND_OBJECT_ENTITY, entity, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_GRAPHICS);
		MailRoom.getInstance().postRequest(GraphicsController.STATE_TYPE, stateType, 
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_GRAPHICS);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}
