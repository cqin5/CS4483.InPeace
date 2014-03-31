package com.inpeace.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import com.inpeace.entities.AbstractTextInputEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   31 Mar 2014
 */
public class Keyboard implements KeyListener {

	/**   */
	private static Keyboard instance;

	/**   */
	private AbstractTextInputEntity focus;

	/**   */
	private HashMap<Character, HotKey> hotkeys;

	/**
	 * Constructs a new Keyboard object.
	 *
	 */
	private Keyboard() {
		super();
		focus = null;
		hotkeys = new HashMap<Character, HotKey>();
	}

	/**
	 * @return
	 */
	public static Keyboard getInstance() {
		if (instance == null) {
			instance = new Keyboard();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		HotKey hotKey = null;
		if (focus != null) {
			focus.keyPress(e);
		}
		else if ((hotKey = hotkeys.get(e.getKeyChar())) != null) {
			hotKey.pressed();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		//NULL BODY
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		//NULL BODY
	}

	/**
	 * @param entity
	 */
	public void getFocus(AbstractTextInputEntity entity) {
		focus = entity;
	}

	/**
	 * 
	 */
	public void removeFocus(AbstractTextInputEntity entity) {
		if (focus == entity) {
			focus = null;
		}
	}

	/**
	 * @param hotKey
	 */
	public void registerHotKey(HotKey hotKey) {
		hotkeys.put(hotKey.getKey(), hotKey);
	}

	/**
	 * @param hotKey
	 */
	public void deregisterHotKey(HotKey hotKey) {
		hotkeys.remove(hotKey.getKey());
	}

}
