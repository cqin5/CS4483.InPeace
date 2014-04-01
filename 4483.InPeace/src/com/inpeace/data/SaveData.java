package com.inpeace.data;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.events.AbstractEvent;
import com.inpeace.models.AudioModel;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.SettingsModel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class SaveData implements Serializable {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 8771165689031839746L;

	/**   */
	private String username = null;

	/**   */
	private int currentLevel = 1;

	/**   */
	private boolean[] collectibles = {false};

	/**   */
	private ArrayList<AbstractEvent> events;

	/**   */
	private SettingsModel settingsModel = null;
	private DefaultGraphicsModel defaultGraphicsModel = null;
	private AudioModel audioModel = null;

	/**
	 * Get the username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the currentLevel
	 *
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Set the currentLevel
	 *
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Get the collectibles
	 *
	 * @return the collectibles
	 */
	public boolean[] getCollectibles() {
		return collectibles;
	}

	/**
	 * Set the collectibles
	 *
	 * @param collectibles the collectibles to set
	 */
	public void setCollectibles(boolean[] collectibles) {
		this.collectibles = collectibles;
	}

	/**
	 * @param index
	 */
	public void setCollected(int index) {
		if (index < collectibles.length && index >= 0) {
			collectibles[index] = true;
		}
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
	 * Get the settingsModel
	 *
	 * @return the settingsModel
	 */
	public SettingsModel getSettingsModel() {
		return settingsModel;
	}

	/**
	 * Set the settingsModel
	 *
	 * @param settingsModel the settingsModel to set
	 */
	public void setSettingsModel(SettingsModel settingsModel) {
		this.settingsModel = settingsModel;
	}

	/**
	 * Get the defaultGraphicsModel
	 *
	 * @return the defaultGraphicsModel
	 */
	public DefaultGraphicsModel getDefaultGraphicsModel() {
		return defaultGraphicsModel;
	}

	/**
	 * Set the defaultGraphicsModel
	 *
	 * @param defaultGraphicsModel the defaultGraphicsModel to set
	 */
	public void setDefaultGraphicsModel(DefaultGraphicsModel defaultGraphicsModel) {
		this.defaultGraphicsModel = defaultGraphicsModel;
	}

	/**
	 * Get the audioModel
	 *
	 * @return the audioModel
	 */
	public AudioModel getAudioModel() {
		return audioModel;
	}

	/**
	 * Set the audioModel
	 *
	 * @param audioModel the audioModel to set
	 */
	public void setAudioModel(AudioModel audioModel) {
		this.audioModel = audioModel;
	}

}
