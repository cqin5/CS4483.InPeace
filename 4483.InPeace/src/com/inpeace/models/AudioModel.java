package com.inpeace.models;

import com.inpeace.controllers.PropertyName;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class AudioModel extends AbstractModel {

	/**   */
	private static final long serialVersionUID = 1205423385254211930L;

	/**   */
	private String musicName;

	/**
	 * Constructs a new AudioModel object.
	 *
	 */
	public AudioModel() {
		super();
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
			fireChange(PropertyName.BACKGROUND_MUSIC_NAME, musicName);
		}
	}

	/**
	 * @param effectName
	 */
	public void setSoundEffect(String effectName) {
		fireChange(PropertyName.SOUND_EFFECT, effectName);
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(PropertyName.BACKGROUND_MUSIC_NAME, musicName);
	}

}
