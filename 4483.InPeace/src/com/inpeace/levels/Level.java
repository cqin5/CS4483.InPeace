package com.inpeace.levels;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.events.AbstractEvent;
import com.inpeace.models.AudioModel;
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
	
	/**   */
	private AudioModel audio = null;
	
	/**   */
	private DefaultGraphicsModel graphicsModel = null;
	
	/**   */
	private ArrayList<AbstractEvent> events;
	
	/**
	 * Constructs a new Level object.
	 *
	 */
	public Level() {
		construct();
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
	 * Get the audio
	 *
	 * @return the audio
	 */
	public AudioModel getAudio() {
		return audio;
	}

	/**
	 * Set the audio
	 *
	 * @param audio the audio to set
	 */
	public void setAudio(AudioModel audio) {
		this.audio = audio;
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
	
	/**
	 * 
	 */
	public abstract void load();
	
}
