package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractAction;
import com.inpeace.exceptions.KeyboardException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.input.HotKey;
import com.inpeace.input.Keyboard;

/**
 * The extendible superclass of all Entities.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public abstract class AbstractEntity {

	/**   */
	private int depth;

	/**   */
	private Rectangle bounds;

	/**   */
	private boolean pressed;

	/**   */
	private AbstractAction pressAction;

	/**   */
	private char hotKey;

	/**
	 * Constructs a new AbstractEntityGraphic object.
	 *
	 * @param depth
	 */
	public AbstractEntity(int depth, AbstractAction pressAction, char hotKey, 
			Rectangle bounds) {
		setDepth(depth);
		setPressed(false);
		setMousePressAction(pressAction);
		setHotKey(hotKey);
		setBounds(bounds);
	}

	/**
	 * Get the depth
	 *
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Set the depth
	 *
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Set the bounds
	 *
	 * @param bounds the bounds to set
	 */
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean contains(Point p) {
		if (bounds != null) {
			if (bounds.contains(p)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the pressed
	 *
	 * @return the pressed
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * Set the pressed
	 *
	 * @param pressed the pressed to set
	 */
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}


	/**
	 * @param pressAction
	 */
	public void setMousePressAction(AbstractAction pressAction) {
		this.pressAction = pressAction;
	}

	/**
	 * Get the position
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return bounds.getLocation();
	}

	/**
	 * Set the position
	 *
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		bounds.add(position);
	}

	/**
	 * @return
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * @return
	 */
	public void press() {
		if (pressAction != null) {
			pressAction.execute();
		}
	}

	/**
	 * @param g
	 */
	public abstract void paint(Graphics2D g, int scrollPosition, Point mousePosition, boolean active)
			throws ResourceAccessException;

	/**
	 * Get the hotKey
	 *
	 * @return the hotKey
	 */
	public char getHotKey() {
		return hotKey;
	}

	/**
	 * Set the hotKey
	 *
	 * @param hotKey the hotKey to set
	 */
	public void setHotKey(char hotKey) {
		this.hotKey = hotKey;
	}

	/**
	 * @throws KeyboardException
	 */
	public void registerHotKey() throws KeyboardException {
		if (hotKey != '\u0000') {
			Keyboard.getInstance().registerHotKey(new HotKey(hotKey, this));
		}
	}

}
