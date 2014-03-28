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

	private String musicName;

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

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(DefaultController.BACKGROUND_MUSIC_NAME, musicName);
	}

}
