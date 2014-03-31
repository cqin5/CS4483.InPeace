package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;

import com.inpeace.actions.AbstractAction;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   30 Mar 2014
 */
public class TextFieldEntity extends AbstractEntity {
	
	/**   */
	private TextField field;
	
	/**
	 * Constructs a new TextFieldEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param bounds
	 */
	public TextFieldEntity(int depth, AbstractAction pressAction,
			AbstractAction enterAction, Rectangle bounds) {
		super(depth, pressAction, enterAction, bounds);
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
