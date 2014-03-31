package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;

import com.inpeace.GameProperties;
import com.inpeace.actions.AbstractAction;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteCode;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ImageEntity extends AbstractImageEntity {

	/**   */
	private int highlightLine;
	private int pressedLine;

	/**
	 * Constructs a new ImageEntity object.
	 *
	 * @param depth
	 * @param actions
	 * @param spriteCode
	 * @param mouseOverSpriteCode
	 * @throws EntityException 
	 */
	public ImageEntity(int depth, AbstractAction pressAction, SpriteCode spriteCode, 
			boolean highlightable, boolean pressable, Point position)
					throws EntityException {

		super(depth, pressAction, spriteCode, position);
		
		highlightLine = 0;
		pressedLine = 0;
		if (highlightable && pressable) {
			highlightLine = 1;
			pressedLine = 2;
		}
		else if (highlightable || pressable) {
			if (highlightable) {
				highlightLine = 1;
			}
			else {
				pressedLine = 1;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#paint(java.awt.Graphics2D)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mouse, boolean active) 
			throws ResourceAccessException {
		
		int x = getPosition().x - scrollPosition;
		if (x < (GameProperties.DEFAULT_WIDTH + getSpriteCode().width) 
				&& x > (0 - getSpriteCode().width)) {
			
			if (active && isPressed()) {
				g.drawImage(getImage(pressedLine, getCurrentVersion()), x, getPosition().y, null);
			}
			else if (active && contains(mouse)) {
				g.drawImage(getImage(highlightLine, getCurrentVersion()) , x, getPosition().y, null);
			}
			else {
				g.drawImage(getImage(0, getCurrentVersion()) , x, getPosition().y, null);
			}
		}
	}

}
