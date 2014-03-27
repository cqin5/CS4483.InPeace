package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.ActionRegistrar;
import com.inpeace.exceptions.IncompatibleObjectException;
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
	private boolean mousePress;

	/**   */
	private Integer mousePressID = null;

	/**   */
	private Integer enterID = null;

	/**
	 * Constructs a new AbstractEntityGraphic object.
	 *
	 * @param depth
	 */
	public AbstractEntity(int depth, AbstractAction pressAction, AbstractAction enterAction) {
		setDepth(depth);
		setMousePress(false);
		setMousePressAction(pressAction);
		this.setEnterAction(enterAction);
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
	 * Get the mousePress
	 *
	 * @return the mousePress
	 */
	public boolean isMousePress() {
		return mousePress;
	}

	/**
	 * Set the mousePress
	 *
	 * @param mousePress the mousePress to set
	 */
	public void setMousePress(boolean mousePress) {
		this.mousePress = mousePress;
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
	 * @return
	 */
	public void press() {
		if (mousePressID != null && mousePressID != 0) {
			ActionRegistrar.getInstance().getAction(mousePressID).performAction();
		}
	}

	/**
	 * @return
	 */
	public void enter() {
		if (enterID != null && enterID != 0) {
			ActionRegistrar.getInstance().getAction(enterID).performAction();
		}
	}

	/**
	 * @param graphic
	 * @return
	 */
	public abstract boolean update(AbstractEntity graphic) throws IncompatibleObjectException;

	/**
	 * @param g
	 */
	public abstract void paint(Graphics2D g, int scrollPosition, Point mousePosition, boolean active)
			throws ResourceAccessException;

}
