package com.inpeace.library;

import javax.sound.sampled.Clip;

import com.inpeace.audio.AudioLoader;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class SoundLibrary {

	private static final String soundsPath = "/com/inpeace/sounds/";

	/**
	 * 
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public static Clip get(String name) throws ResourceAccessException {
		return AudioLoader.loadAudio(soundsPath + name + ".wav");
	}

}
