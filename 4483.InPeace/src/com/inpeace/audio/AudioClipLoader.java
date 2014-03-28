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
public class AudioClipLoader {

	public static Clip loadClip(String relativePath) throws ResourceAccessException {
		Clip clip = null;
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(
					AudioClipLoader.class.getResource(relativePath));
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			throw new ResourceAccessException("Opps! It appears there was trouble finding "
					+ "the audio clip: " + relativePath + " (AudioClipLoader)");
		} catch (LineUnavailableException e) {
			System.out.print("line unavailable\n\n\n\n\n");

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			System.out.print("unsupported\n\n\n\n\n");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clip;
	}
}