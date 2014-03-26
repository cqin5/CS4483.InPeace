package com.inpeace.graphics;

import java.awt.Graphics2D;

import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public abstract class AbstractEntityGraphic {

	/**   */
	private int depth;
	
	/**
	 * Constructs a new AbstractEntityGraphic object.
	 *
	 * @param depth
	 */
	public AbstractEntityGraphic(int depth) {
		setDepth(depth);
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
	 * @param graphic
	 * @return
	 */
	public abstract boolean update(AbstractEntityGraphic graphic) throws IncompatibleObjectException ;
	
	/**
	 * @param g
	 */
	public abstract void paint(Graphics2D g, int scrollPosition) throws ResourceAccessException ;

}
