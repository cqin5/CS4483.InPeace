package com.inpeace.engine;

import com.inpeace.controllers.PropertyName;
import com.inpeace.data.SaveData;
import com.inpeace.engine.Request.RequestType;
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
	
	/**   */
	private DefaultGraphicsModel defaultGraphicsModel;
	private AudioModel audioModel;
	private HUDGraphicsModel hudGraphicsModel;
	private OverlayGraphicsModel overlayGraphicsModel;
	
	/**
	 * Constructs a new PersistentDataHandler object.
	 *
	 */
	private DataManager() {
		save = new SaveData();
		defaultGraphicsModel = null;
		audioModel = null;
		hudGraphicsModel = null;
		overlayGraphicsModel = null;
		
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

	/**
	 * @param LevelNum
	 * @return
	 */
	public Level createLevel(int levelNum) {
		Level level = LevelFactory.buildLevel(levelNum);
		level.load();
		setCurrentLevel(levelNum);
		return level;
	}
	
	/**
	 * 
	 */
	public void storeGameProgress() {
		save.setAudioModel(getAudioModel());
		save.setDefaultGraphicsModel(getDefaultGraphicsModel());
		save.setEvents(Scheduler.getInstance().getSnapshot());
	}
	
	/**
	 * 
	 */
	public void restoreGameProgress() {
		MailRoom mail = MailRoom.getInstance();
		mail.postRequest(PropertyName.AUDIO_MODEL, save.getAudioModel(), RequestType.REGISTER);
		mail.postRequest(PropertyName.DEFAULT_GRAPHICS_MODEL, save.getDefaultGraphicsModel(),
				RequestType.REGISTER);
		Scheduler.getInstance().restoreSnapshot(save.getEvents());
	}
	
	/**
	 * 
	 */
	public void save() {
		//TODO
	}
	
	/**
	 * @param username
	 */
	public void load(String username) {
		//TODO
	}

}
