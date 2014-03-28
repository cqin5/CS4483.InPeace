package com.inpeace.states;

import java.util.ArrayList;

import com.inpeace.engine.DataManager;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.engine.StateManager;
import com.inpeace.models.OverlayGraphicsModel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class ScrollState extends AbstractState {
	
	private final static String graphicSpriteCode = "1-0-0-128-128";

	/**
	 * Constructs a new ScrollState object.
	 *
	 * @param type
	 * @param stateID
	 * @param historical
	 */
	public ScrollState() {
		super(AbstractState.OVERLAY_SCREEN, StateManager.SCROLL, false);
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
		
		model.setOverlaySpriteCode(graphicSpriteCode);

		MailRoom.getInstance().postRequest(DataManager.OVERLAY_GRAPHICS_MODEL, model, 
				Request.REGISTRATION_REQUEST);
		
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
