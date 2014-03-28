package com.inpeace.engine;

import java.beans.PropertyChangeEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.Clip;

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
	
	private Clip backgroundMusic = null;

	private Queue<Clip> soundEffects = new LinkedList<Clip>();
	
	public AudioManager() {
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
					backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
				}
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(DefaultController.SOUND_EFFECT)) {
			try {
				soundEffects.add(Librarian.getInstance().getSound((String) e.getNewValue()));
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#refresh()
	 */
	@Override
	public void refresh() {
		for (Clip clip: soundEffects) {
			clip.start();
		}
	}
	
}
