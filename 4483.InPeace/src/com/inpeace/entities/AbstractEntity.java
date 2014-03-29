package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.ActionRegistrar;
import com.inpeace.exceptions.ResourceAccessException;

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
	protected Rectangle bounds;

	/**   */
	private boolean pressed;

	/**   */
	private Integer mousePressID = null;

	/**   */
	private Integer enterID = null;

	/**
	 * Constructs a new AbstractEntityGraphic object.
	 *
	 * @param depth
	 */
	public AbstractEntity(int depth, AbstractAction pressAction, AbstractAction enterAction, Rectangle bounds) {
		setDepth(depth);
		setPressed(false);
		setMousePressAction(pressAction);
		setEnterAction(enterAction);
		this.bounds = bounds;
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
	 * @param action
	 */
	public void setMousePressAction(AbstractAction action) {
		if (action != null) {
			mousePressID = ActionRegistrar.getInstance().registerAction(action);
		}
		else {
			mousePressID = null;
		}
	}

	/**
	 * @param action
	 */
	public void setEnterAction(AbstractAction action) {
		if (action != null) {
			enterID = ActionRegistrar.getInstance().registerAction(action);
		}
		else {
			enterID = null;
		}
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
		if (mousePressID != null && mousePressID != 0) {
			ActionRegistrar.getInstance().getAction(mousePressID).execute();
		}
	}

	/**
	 * @return
	 */
	public void enter() {
		if (enterID != null && enterID != 0) {
			ActionRegistrar.getInstance().getAction(enterID).execute();
		}
	}

	/**
	 * @param g
	 */
	public abstract void paint(Graphics2D g, int scrollPosition, Point mousePosition, boolean active)
			throws ResourceAccessException;

}
