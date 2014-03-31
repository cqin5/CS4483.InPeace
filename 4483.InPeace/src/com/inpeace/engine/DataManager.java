package com.inpeace.engine;

import java.util.ArrayList;

import com.inpeace.data.SaveData;
import com.inpeace.events.AbstractEvent;
import com.inpeace.levels.Level;
import com.inpeace.levels.LevelFactory;
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
 * @version 2.0
 * @since   24 Mar 2014
 */
public class DataManager {

	/**   */
	private static DataManager instance = null;
	
	/**   */
	private SaveData save;
	
	/**
	 * Constructs a new PersistentDataHandler object.
	 *
	 */
	private DataManager() {
		save = new SaveData();
	}
	
	public static DataManager getInstance() {
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}
	
	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getEvents()
	 */
	public ArrayList<AbstractEvent> getEvents() {
		return save.getEvents();
	}

	/**
	 * @param events
	 * @see com.inpeace.data.SaveData#setEvents(java.util.ArrayList)
	 */
	public void setEvents(ArrayList<AbstractEvent> events) {
		save.setEvents(events);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getPlayerModel()
	 */
	public PlayerModel getPlayerModel() {
		return save.getPlayerModel();
	}

	/**
	 * @param playerModel
	 * @see com.inpeace.data.SaveData#setPlayerModel(com.inpeace.models.PlayerModel)
	 */
	public void setPlayerModel(PlayerModel playerModel) {
		save.setPlayerModel(playerModel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getSettingsModel()
	 */
	public SettingsModel getSettingsModel() {
		return save.getSettingsModel();
	}

	/**
	 * @param settingsModel
	 * @see com.inpeace.data.SaveData#setSettingsModel(com.inpeace.models.SettingsModel)
	 */
	public void setSettingsModel(SettingsModel settingsModel) {
		save.setSettingsModel(settingsModel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getDefaultGraphicsModel()
	 */
	public DefaultGraphicsModel getDefaultGraphicsModel() {
		return save.getDefaultGraphicsModel();
	}

	/**
	 * @param defaultGraphicsModel
	 * @see com.inpeace.data.SaveData#setDefaultGraphicsModel(com.inpeace.models.DefaultGraphicsModel)
	 */
	public void setDefaultGraphicsModel(
			DefaultGraphicsModel defaultGraphicsModel) {
		save.setDefaultGraphicsModel(defaultGraphicsModel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getHudGraphicsModel()
	 */
	public HUDGraphicsModel getHudGraphicsModel() {
		return save.getHudGraphicsModel();
	}

	/**
	 * @param hudGraphicsModel
	 * @see com.inpeace.data.SaveData#setHudGraphicsModel(com.inpeace.models.HUDGraphicsModel)
	 */
	public void setHudGraphicsModel(HUDGraphicsModel hudGraphicsModel) {
		save.setHudGraphicsModel(hudGraphicsModel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getOverlayGraphicsModel()
	 */
	public OverlayGraphicsModel getOverlayGraphicsModel() {
		return save.getOverlayGraphicsModel();
	}

	/**
	 * @param overlayGraphicsModel
	 * @see com.inpeace.data.SaveData#setOverlayGraphicsModel(com.inpeace.models.OverlayGraphicsModel)
	 */
	public void setOverlayGraphicsModel(
			OverlayGraphicsModel overlayGraphicsModel) {
		save.setOverlayGraphicsModel(overlayGraphicsModel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getAudioModel()
	 */
	public AudioModel getAudioModel() {
		return save.getAudioModel();
	}

	/**
	 * @param audioModel
	 * @see com.inpeace.data.SaveData#setAudioModel(com.inpeace.models.AudioModel)
	 */
	public void setAudioModel(AudioModel audioModel) {
		save.setAudioModel(audioModel);
	}

	/**
	 * @param LevelNum
	 * @return
	 */
	public Level loadLevel(int levelNum) {
		Level level = LevelFactory.buildLevel(levelNum);
		level.load();
		getPlayerModel().setCurrentLevel(levelNum);
		return level;
	}
	
	/**
	 * @param collectibleIndex
	 */
	public void foundCollectible(int collectibleIndex) {
		getPlayerModel().setCollected(collectibleIndex);
	}

}
