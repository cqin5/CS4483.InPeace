package com.inpeace.audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class AudioLoader {

	/**
	 * @param relativePath
	 * @return
	 * @throws ResourceAccessException
	 */
	public static Clip loadAudio(String relativePath)
			throws ResourceAccessException {
		
		Clip clip = null;
		AudioInputStream stream = null;
		try {
			stream = AudioSystem.getAudioInputStream(
					AudioLoader.class.getResource(relativePath));
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					//NULL BODY
				}
			}
			throw new ResourceAccessException("Opps! It appears there was trouble loading "
					+ "the audio clip: " + relativePath + " (AudioClipLoader)");
		} 
		return clip;
	}
	
}