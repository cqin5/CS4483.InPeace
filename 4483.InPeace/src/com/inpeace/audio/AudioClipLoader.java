package com.inpeace.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class AudioClipLoader {

	public static Clip loadClip(String relativePath) throws ResourceAccessException {
		Clip clip;
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(
					AudioClipLoader.class.getResource(relativePath));
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception e) {
			throw new ResourceAccessException("Opps! It appears there was trouble finding "
					+ "the audio clip: " + relativePath + " (AudioClipLoader");
		}
		return clip;
	}
}