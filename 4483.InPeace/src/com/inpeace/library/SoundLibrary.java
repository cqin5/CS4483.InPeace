package com.inpeace.library;

import java.util.HashMap;

import javax.sound.sampled.Clip;

import com.inpeace.audio.AudioClipLoader;
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
	
	/**   */
	HashMap<String, Clip> library;
	
	/**
	 * Constructs a new SoundLibrary object.
	 *
	 */
	public SoundLibrary() {
		library = new HashMap<String, Clip>();
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public Clip get(String name) throws ResourceAccessException {
		Clip clip = null;
		if (name.equals("")) {
			return null;
		}
		name.toLowerCase();
		clip = library.get(name);
		if (clip == null) {
			add(name);
			return get(name);
		}
		return clip;
	}
	
	/**
	 * 
	 * @param name
	 * @throws ResourceAccessException
	 */
	private void add(String name) throws ResourceAccessException {
		library.put(name, AudioClipLoader.loadClip(soundsPath + name + ".wav"));
	}
	
}
