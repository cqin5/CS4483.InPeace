package com.inpeace.data;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.events.AbstractEvent;
import com.inpeace.models.AudioModel;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.HUDGraphicsModel;
import com.inpeace.models.OverlayGraphicsModel;
import com.inpeace.models.PlayerModel;
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
	private ArrayList<AbstractEvent> events;
	
	/**   */
	private PlayerModel playerModel = null;
	private SettingsModel settingsModel = null;
	private DefaultGraphicsModel defaultGraphicsModel = null;
	private HUDGraphicsModel hudGraphicsModel = null;
	private OverlayGraphicsModel overlayGraphicsModel = null;
	private AudioModel audioModel = null;
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
	 * Get the playerModel
	 *
	 * @return the playerModel
	 */
	public PlayerModel getPlayerModel() {
		return playerModel;
	}
	/**
	 * Set the playerModel
	 *
	 * @param playerModel the playerModel to set
	 */
	public void setPlayerModel(PlayerModel playerModel) {
		this.playerModel = playerModel;
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
	 * Get the hudGraphicsModel
	 *
	 * @return the hudGraphicsModel
	 */
	public HUDGraphicsModel getHudGraphicsModel() {
		return hudGraphicsModel;
	}
	/**
	 * Set the hudGraphicsModel
	 *
	 * @param hudGraphicsModel the hudGraphicsModel to set
	 */
	public void setHudGraphicsModel(HUDGraphicsModel hudGraphicsModel) {
		this.hudGraphicsModel = hudGraphicsModel;
	}
	/**
	 * Get the overlayGraphicsModel
	 *
	 * @return the overlayGraphicsModel
	 */
	public OverlayGraphicsModel getOverlayGraphicsModel() {
		return overlayGraphicsModel;
	}
	/**
	 * Set the overlayGraphicsModel
	 *
	 * @param overlayGraphicsModel the overlayGraphicsModel to set
	 */
	public void setOverlayGraphicsModel(OverlayGraphicsModel overlayGraphicsModel) {
		this.overlayGraphicsModel = overlayGraphicsModel;
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
