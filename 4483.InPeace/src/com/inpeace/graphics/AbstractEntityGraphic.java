package com.inpeace.graphics;

import java.awt.Graphics2D;

import com.inpeace.images.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public interface AbstractEntityGraphic {
	
	/**
	 * @param graphic
	 * @return
	 */
	public boolean update(AbstractEntityGraphic graphic) throws IncompatibleObjectException ;
	
	/**
	 * @param g
	 */
	public void paint(Graphics2D g) throws ResourceAccessException ;

}
