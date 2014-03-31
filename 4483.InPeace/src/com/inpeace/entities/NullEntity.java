package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;

import com.inpeace.exceptions.ResourceAccessException;

/**
 * Used when you want to send a request that will remove a specific entity from the view.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class NullEntity extends AbstractEntity {

	/**
	 * Constructs a new NullEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param bounds
	 */
	public NullEntity(int depth) {
		super(depth, null, null, null);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		// TODO Auto-generated method stub
		
	}

}
