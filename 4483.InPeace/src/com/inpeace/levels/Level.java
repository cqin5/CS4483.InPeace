package com.inpeace.levels;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.events.AbstractEvent;
import com.inpeace.models.DefaultGraphicsModel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public abstract class Level implements Serializable {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -7604971177826975662L;
	
	private String musicName = null;
	
	/**   */
	private DefaultGraphicsModel graphicsModel = null;
	
	/**   */
	private ArrayList<AbstractEvent> events = null;
	
	public Level() {
		construct();
	}

	/**
	 * Get the musicName
	 *
	 * @return the musicName
	 */
	public String getMusicName() {
		return musicName;
	}

	/**
	 * Set the musicName
	 *
	 * @param musicName the musicName to set
	 */
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	/**
	 * Get the graphicsModel
	 *
	 * @return the graphicsModel
	 */
	public DefaultGraphicsModel getGraphicsModel() {
		return graphicsModel;
	}

	/**
	 * Set the graphicsModel
	 *
	 * @param graphicsModel the graphicsModel to set
	 */
	public void setGraphicsModel(DefaultGraphicsModel graphicsModel) {
		this.graphicsModel = graphicsModel;
	}

	/**
	 * Get the events
	 *
	 * @return the events
	 */
	public ArrayList<AbstractEvent> getEvents() {
		return events;
	}

	/**
	 * Set the events
	 *
	 * @param events the events to set
	 */
	public void setEvents(ArrayList<AbstractEvent> events) {
		this.events = events;
	}
	
	/**
	 * 
	 */
	public abstract void construct();
	
}
