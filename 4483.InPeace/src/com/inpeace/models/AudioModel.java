package com.inpeace.models;

import com.inpeace.controllers.DefaultController;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class AudioModel extends AbstractModel {

	/**   */
	private String musicName;

	/**   */
	private float musicVolume;

	/**   */
	private float fxVolume;

	public AudioModel() {
		setMusicName("");
	}

	/**
	 * Set the musicName
	 *
	 * @param musicName the musicName to set
	 */
	public void setMusicName(String musicName) {
		if (this.musicName != musicName) {
			this.musicName = musicName;
			fireChange(DefaultController.BACKGROUND_MUSIC_NAME, musicName);
		}
	}

	/**
	 *
	 */
	public void clearMusicName() {
		musicName = null;
	}

	/**
	 * @param effectName
	 */
	public void setSoundEffect(String effectName) {
		fireChange(DefaultController.SOUND_EFFECT, effectName);
	}

	/**
	 * Set the musicVolume
	 *
	 * @param musicVolume the musicVolume to set
	 */
	public void setMusicVolume(float musicVolume) {
		if (this.musicVolume != musicVolume) {
			this.musicVolume = musicVolume;
			fireChange(DefaultController.BACKGROUND_MUSIC_VOLUME, musicVolume);
		}
	}
	
	/**
	 * 
	 */
	public void clearMusicVolume() {
		setMusicVolume(-5.0f);
	}

	/**
	 * Set the fxVolume
	 *
	 * @param fxVolume the fxVolume to set
	 */
	public void setFXVolume(float fxVolume) {
		if (this.fxVolume != fxVolume) {
			this.fxVolume = fxVolume;
			fireChange(DefaultController.SOUND_EFFECTS_VOLUME, fxVolume);
		}
	}

	/**
	 * 
	 */
	public void clearFXVolume() {
		setFXVolume(0.0f);
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(DefaultController.BACKGROUND_MUSIC_NAME, musicName);
		fireChange(DefaultController.BACKGROUND_MUSIC_VOLUME, musicVolume);
		fireChange(DefaultController.SOUND_EFFECTS_VOLUME, fxVolume);
	}

}
