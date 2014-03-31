package com.inpeace.entities;

import java.awt.Point;
import java.awt.event.KeyEvent;

import com.inpeace.actions.TextInputFocusAction;
import com.inpeace.characterfilter.AbstractCharacterFilter;
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
	private static final long flashInterval = 700;

	/**   */
	private long nextFlash;

	private AbstractCharacterFilter filter;

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
			setNextFlash();
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
	public void setNextFlash() {
		this.nextFlash = System.currentTimeMillis() + flashInterval;
	}

	/**
	 * Set the filter
	 *
	 * @param filter the filter to set
	 */
	public void setFilter(AbstractCharacterFilter filter) {
		this.filter = filter;
	}

	/**
	 * @param key
	 */
	public void keyPress(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '\u0008') {
			backspace();
		}
		else if (c == '\n') {
			enter();
		}
		else if (c >= ' ' && c <= '~') {
			if (filter == null) {
				key(c);
			}
			else {
				if (filter.filter(c)) {
					key(c);
				}
			}
		}
	}

	/**
	 * 
	 */
	public abstract void enter();

	/**
	 * 
	 */
	public abstract void backspace();

	/**
	 * 
	 */
	public abstract void key(char c);

}
