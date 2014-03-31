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
	 * @see com.inpeace.data.SaveData#getUsername()
	 */
	public String getUsername() {
		return save.getUsername();
	}

	/**
	 * @param username
	 * @see com.inpeace.data.SaveData#setUsername(java.lang.String)
	 */
	public void setUsername(String username) {
		save.setUsername(username);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getCurrentLevel()
	 */
	public int getCurrentLevel() {
		return save.getCurrentLevel();
	}

	/**
	 * @param currentLevel
	 * @see com.inpeace.data.SaveData#setCurrentLevel(int)
	 */
	public void setCurrentLevel(int currentLevel) {
		save.setCurrentLevel(currentLevel);
	}

	/**
	 * @return
	 * @see com.inpeace.data.SaveData#getCollectibles()
	 */
	public boolean[] getCollectibles() {
		return save.getCollectibles();
	}

	/**
	 * @param collectibles
	 * @see com.inpeace.data.SaveData#setCollectibles(boolean[])
	 */
	public void setCollectibles(boolean[] collectibles) {
		save.setCollectibles(collectibles);
	}

	/**
	 * @param index
	 * @see com.inpeace.data.SaveData#setCollected(int)
	 */
	public void setCollected(int index) {
		save.setCollected(index);
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
		setCurrentLevel(levelNum);
		return level;
	}

}
