package com.inpeace.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.inpeace.entities.ImageEntity;

/**
 * The class EnterListener, a key listener.
 * 
 * @author	James Anderson
 * @version 1.1
 * @since	4 November 2013
 */
public class EnterListener implements KeyListener {
	
	/** The button to act on. */
	private ImageEntity button;
	
	/**
	 * Instantiates an EnterListener instance.
	 *
	 * @param button	the button
	 */
	public EnterListener(ImageEntity button) {
		super();
		this.button = button;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			button.press();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		/*NULL BODY*/
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		/*NULL BODY*/
	}
}
