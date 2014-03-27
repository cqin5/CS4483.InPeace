package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
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
	private Integer clickActionCode;
	
	/**
	 * Constructs a new AbstractEntityGraphic object.
	 *
	 * @param depth
	 */
	public AbstractEntity(int depth, int clickActionCode) {
		setDepth(depth);
		setClickActionCode(clickActionCode);
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
	public boolean contains(int x, int y) {
		if (bounds.contains(x, y)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param graphic
	 * @return
	 */
	public abstract boolean update(AbstractEntity graphic) throws IncompatibleObjectException ;
	
	/**
	 * @param g
	 */
	public abstract void paint(Graphics2D g, int scrollPosition) throws ResourceAccessException ;

	/**
	 * Get the clickActionCode
	 *
	 * @return the clickActionCode
	 */
	public Integer getClickActionCode() {
		return clickActionCode;
	}

	/**
	 * Set the clickActionCode
	 *
	 * @param clickActionCode the clickActionCode to set
	 */
	public void setClickActionCode(Integer clickActionCode) {
		this.clickActionCode = clickActionCode;
	}

}
