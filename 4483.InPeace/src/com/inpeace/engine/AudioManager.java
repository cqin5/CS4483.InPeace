package com.inpeace.engine;

import java.beans.PropertyChangeEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.inpeace.controllers.DefaultController;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;
import com.inpeace.views.AbstractView;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class AudioManager implements AbstractView {

	private float musicVolume;
	
	private float fxVolume;
	
	private Clip backgroundMusic;

	private Queue<Clip> soundEffects;

	public AudioManager() {
		musicVolume = -5.0f;
		fxVolume = 0.0f;
		backgroundMusic = null;
		soundEffects = new LinkedList<Clip>();
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#update(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void update(PropertyChangeEvent e) {
		if (e.getPropertyName().equals(DefaultController.BACKGROUND_MUSIC_NAME)) {
			try {
				if (backgroundMusic != null) {
					backgroundMusic.stop();
				}
				backgroundMusic = Librarian.getInstance().getSound((String) e.getNewValue());
				if (backgroundMusic != null) {
					FloatControl volume = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(musicVolume);
					backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
				}
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(DefaultController.SOUND_EFFECT)) {
			try {
				Clip clip = Librarian.getInstance().getSound((String) e.getNewValue());
				if (clip != null) {
					soundEffects.add(clip);
				}
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(DefaultController.BACKGROUND_MUSIC_VOLUME)) {
			musicVolume = (float) e.getNewValue();
		}
		else if (e.getPropertyName().equals(DefaultController.SOUND_EFFECTS_VOLUME)) {
			fxVolume = (float) e.getNewValue();
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#refresh()
	 */
	@Override
	public void refresh() {
		if (soundEffects != null) {
			for (Clip clip: soundEffects) {
				FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(fxVolume);
				clip.start();
			}
		}
	}

}
