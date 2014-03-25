package com.inpeace.states;

import java.util.AbstractMap.SimpleEntry;

import com.inpeace.engine.AudioManager;
import com.inpeace.engine.DataManager;
import com.inpeace.engine.GraphicsManager;
import com.inpeace.engine.LogicManager;
import com.inpeace.graphics.AbstractEntityGraphic;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   24 Mar 2014
 */
public abstract class AbstractState {

	/**   */
	private int type; //0 = splash, 1 = menu, 2 = in game, 3 = overlay
	
	/**   */
	private int stateID;
	
	/**   */
	private int scrollPostion;
	
	/**   */
	private String backgroundName;
	
	public abstract void load(GraphicsManager graphics, AudioManager audio, LogicManager logic, DataManager data);
	
	/**
	 * @return
	 */
	public abstract boolean isHistorical();
	
	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public abstract void close();

	/**
	 * Get the type
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Set the type
	 *
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Get the stateID
	 *
	 * @return the stateID
	 */
	public int getStateID() {
		return stateID;
	}

	/**
	 * Set the stateID
	 *
	 * @param stateID the stateID to set
	 */
	public void setStateID(int stateID) {
		this.stateID = stateID;
	}
	
	/**
	 * @return
	 */
	public int getScrollPosition() {
		return scrollPostion;
	}
	
	public String getBackgroundName() {
		return backgroundName;
	}
	
	/**
	 * @param scrollPosition
	 */
	public void setScrollPosition(int scrollPosition) {
		setModelProperty(HORIZONTAL_SCROLL_POSITION, scrollPosition);
	}
	
	/**
	 * @param name
	 */
	public void setBackground(String name) {
		setModelProperty(BACKGROUND_IMAGE_NAME, name);
	}
	
	/**
	 * @param spriteCode
	 */
	public void setGraphic(long spriteCode, String graphicName) {
		setModelProperty(graphicName, spriteCode);
	}
	
	/**
	 * @param entity		set to null to remove entity
	 * @param depth
	 * @param entityName
	 */
	public void setEntity(AbstractEntityGraphic entity, int depth, String entityName) {
		setModelProperty(entityName, new SimpleEntry<Integer,
				AbstractEntityGraphic>(depth, entity));
	}
	
}
