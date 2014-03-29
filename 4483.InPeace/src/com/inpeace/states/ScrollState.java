package com.inpeace.states;

import java.util.ArrayList;

import com.inpeace.engine.DataManager;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.StateManager.StateID;
import com.inpeace.exceptions.SpriteCodeException;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.models.OverlayGraphicsModel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class ScrollState extends AbstractState {
	
	private final static String graphicSpriteCode = "1-0-0-128-128-4-4";

	/**
	 * Constructs a new ScrollState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public ScrollState() {
		super(StateType.OVERLAY, StateID.SCROLL, false);
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
	public void load() {
		
		OverlayGraphicsModel model = new OverlayGraphicsModel();
		
		try {
			model.setOverlaySpriteCode(SpriteCode.get(graphicSpriteCode));
		} catch (SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MailRoom.getInstance().postRequest(DataManager.OVERLAY_GRAPHICS_MODEL, model, 
				RequestType.REGISTER);
		
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}
