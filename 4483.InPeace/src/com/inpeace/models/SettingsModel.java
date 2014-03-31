package com.inpeace.models;

import com.inpeace.controllers.PropertyName;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class SettingsModel extends AbstractModel {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -2127714796260188343L;

	/**   */
	private float musicVolume;

	/**   */
	private float soundEffectsVolume;

	/**   */
	private double hintDelay;

	/**
	 * Constructs a new SettingsModel object.
	 *
	 */
	public SettingsModel() {
		musicVolume = -10f;
		soundEffectsVolume = -5f;
		hintDelay = 30f;
	}

	/**
	 * Set the musicVolume
	 *
	 * @param musicVolume the musicVolume to set
	 */
	public void setMusicVolume(float musicVolume) {
		if (this.musicVolume != musicVolume) {
			this.musicVolume = musicVolume;
			fireChange(PropertyName.MUSIC_VOLUME, musicVolume);
		}
	}

	/**
	 * Set the soundEffectsVolume
	 *
	 * @param soundEffectsVolume the soundEffectsVolume to set
	 */
	public void setSoundEffectsVolume(float soundEffectsVolume) {
		if (this.soundEffectsVolume != soundEffectsVolume) {
			this.soundEffectsVolume = soundEffectsVolume;
			fireChange(PropertyName.SOUND_EFFECTS_VOLUME, soundEffectsVolume);
		}
	}

	/**
	 * Set the hintDelay
	 *
	 * @param hintDelay the hintDelay to set
	 */
	public void setHintDelay(long hintDelay) {
		if (this.hintDelay != hintDelay) {
			this.hintDelay = hintDelay;
			fireChange(PropertyName.HINT_DELAY, hintDelay);
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(PropertyName.MUSIC_VOLUME, musicVolume);
		fireChange(PropertyName.SOUND_EFFECTS_VOLUME, soundEffectsVolume);
		fireChange(PropertyName.HINT_DELAY, hintDelay);
	}

}
