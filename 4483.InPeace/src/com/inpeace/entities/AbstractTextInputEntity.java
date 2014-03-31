package com.inpeace.entities;

import java.awt.Point;
import java.awt.event.KeyEvent;

import com.inpeace.actions.TextInputFocusAction;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.input.Keyboard;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public abstract class AbstractTextInputEntity extends AbstractImageEntity {
	
	/**   */
	private boolean keyboardFocus;
	
	/**   */
	private static final long flashInterval = 1000;
	
	/**   */
	private long nextFlash;

	/**
	 * Constructs a new AbstractTextInputEntity object.
	 *
	 * @param depth
	 * @param spriteCode
	 * @param position
	 * @param initialFocus
	 */
	public AbstractTextInputEntity(int depth, SpriteCode spriteCode, Point position) {
		
		super(depth, null, (char) 0, spriteCode, position);
		
		this.keyboardFocus = false;
		setMousePressAction(new TextInputFocusAction(this));
	}

	/**
	 * Get the keyboardFocus
	 *
	 * @return the keyboardFocus
	 */
	public boolean isKeyboardFocus() {
		return keyboardFocus;
	}

	/**
	 * Set the keyboardFocus
	 *
	 * @param keyboardFocus the keyboardFocus to set
	 */
	public void setKeyboardFocus(boolean keyboardFocus) {
		if (keyboardFocus == true) {
			Keyboard.getInstance().getFocus(this);
			setNextFlash(System.currentTimeMillis() + flashInterval);
		}
		else {
			Keyboard.getInstance().removeFocus(this);
		}
		this.keyboardFocus = keyboardFocus;
	}
	
	/**
	 * Get the nextFlash
	 *
	 * @return the nextFlash
	 */
	public long getNextFlash() {
		return nextFlash;
	}

	/**
	 * Set the nextFlash
	 *
	 * @param nextFlash the nextFlash to set
	 */
	public void setNextFlash(long nextFlash) {
		this.nextFlash = nextFlash;
	}
	
	/**
	 * @param key
	 */
	public abstract void keyPress(KeyEvent key);

}
