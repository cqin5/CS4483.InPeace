package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

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
	private static final long serialVersionUID = -6252618730561183678L;
	
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
	public ImageEntity(int depth, AbstractAction pressAction, char hotKey, SpriteCode spriteCode, 
			boolean highlightable, boolean pressable, Point position)
					throws EntityException {

		super(depth, pressAction, hotKey, spriteCode, position);
		
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
		int y = getPosition().y;
		int width = getSpriteCode().width;
		int cutx = 0;
		int height = getSpriteCode().height;
		int cuty = 0;

		if (x < (GameProperties.DEFAULT_WIDTH + width) && x > (0 - width) 
				&& y < (GameProperties.DEFAULT_HEIGHT + height) && y > (0 - height)) {
			
			BufferedImage img = null;
			if (active && isPressed()) {
				img = getImage(pressedLine, getCurrentVersion());
			}
			else if (active && contains(mouse)) {
				img = getImage(highlightLine, getCurrentVersion());
			}
			else {
				img = getImage(0, getCurrentVersion());
			}
			
			if ((x + width) > GameProperties.DEFAULT_WIDTH) {
				width = GameProperties.DEFAULT_WIDTH - x;
			}
			else if (x < 0) {
				cutx = -x;
				width -= cutx;
			}
			
			if ((y + height) > GameProperties.DEFAULT_HEIGHT) {
				height = GameProperties.DEFAULT_HEIGHT - y;
			}
			else if (y < 0) {
				cuty = -y;
				height -= cuty;
			}
			
			g.drawImage(img.getSubimage(cutx, 0, width, height), x + cutx, y + cuty, null);
		}
	}

}
