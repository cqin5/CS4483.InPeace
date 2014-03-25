package com.inpeace.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import com.inpeace.Librarian;
import com.inpeace.images.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ImageEntityGraphic implements AbstractEntityGraphic {

	/**   */
	private long spriteCode;
	
	/**   */
	private BufferedImage image;
	
	/**   */
	private Point position;
	
	public ImageEntityGraphic(long spriteCode, Point position) {
		this.spriteCode = spriteCode;
		this.position = position;
		this.image = null;
	}
	
	/**
	 * Get the sprite code
	 *
	 * @return the sprite code
	 */
	public long getSpriteCode() {
		return spriteCode;
	}

	/**
	 * Get the position
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param graphic
	 * @return
	 * @throws IncompatibleObjectException 
	 */
	public boolean update(AbstractEntityGraphic graphic) throws IncompatibleObjectException {
		if (graphic.getClass() != ImageEntityGraphic.class) {
			throw new IncompatibleObjectException("ImageEntityGraphic: unable to update,"
					+ " paramater class does not match");
		}
		boolean change = false;
		if (spriteCode != ((ImageEntityGraphic) graphic).getSpriteCode()) {
			spriteCode = ((ImageEntityGraphic) graphic).getSpriteCode();
			change = true;
		}
		if (position != ((ImageEntityGraphic) graphic).getPosition()) {
			position = ((ImageEntityGraphic) graphic).getPosition();
			change = true;
		}
		return change;
	}
	
	/**
	 * @param g
	 * @throws ResourceAccessException
	 */
	public void paint(Graphics2D g) throws ResourceAccessException {
		if (image == null) {
			image = Librarian.getInstance().getSprite(spriteCode);
		}
		g.drawImage(image , position.x, position.y, null);
	}
	
}
