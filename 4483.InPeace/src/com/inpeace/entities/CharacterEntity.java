package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;

import com.inpeace.actions.AbstractAction;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class CharacterEntity extends AbstractEntity {

	/**
	 * Constructs a new CharacterEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param position
	 */
	public CharacterEntity(int depth, AbstractAction pressAction,
			AbstractAction enterAction, Point position) {
		super(depth, pressAction, enterAction, position);
		// TODO Auto-generated constructor stub
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
