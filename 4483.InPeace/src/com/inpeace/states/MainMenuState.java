 package com.inpeace.states;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.ChangeStateAction;
import com.inpeace.actions.MultiAction;
import com.inpeace.actions.SoundFXAction;
import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.StateManager.StateID;
import com.inpeace.entities.AlphaNumTextFieldEntity;
import com.inpeace.entities.ImageEntity;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.SpriteCodeException;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.models.DefaultGraphicsModel;

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
		super(StateType.DEFAULT, StateID.MAIN_MENU, true);
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
		
		DefaultGraphicsModel model = new DefaultGraphicsModel();
		
		model.setBackgroundName(backgroundName);
	
		ImageEntity entity = null;
		try {
			MultiAction action = new MultiAction(new ChangeStateAction(StateID.SCROLL),
					new SoundFXAction("woow"));
			entity = new ImageEntity(1, action, SpriteCode.get("1-0-0-128-128-4-4"),
					true, true, new Point(0,0));
		} catch (EntityException | SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setForegroundObjectEntity(entity);
		
		AlphaNumTextFieldEntity text = new AlphaNumTextFieldEntity(2, new Rectangle(200,200,200,30), entity,
				"Test...", Color.RED, 20);
		model.setForegroundObjectEntity(text);
		
		MailRoom.getInstance().postRequest(PropertyName.DEFAULT_GRAPHICS_MODEL, model,
				RequestType.REGISTER);
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
	}
	
}
