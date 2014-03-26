package com.inpeace.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import com.inpeace.engine.GameProperties;
import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ImageEntityGraphic extends AbstractEntityGraphic {
	
	/**   */
	private String spriteCode;
	
	/**   */
	private BufferedImage image;
	
	/**   */
	private Point position;
	
	public ImageEntityGraphic(int depth, String spriteCode, Point position) {
		super(depth);
		this.spriteCode = spriteCode;
		this.position = position;
		this.image = null;
	}
	
	/**
	 * Get the sprite code
	 *
	 * @return the sprite code
	 */
	public String getSpriteCode() {
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

	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#update(com.inpeace.graphics.AbstractEntityGraphic)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#paint(java.awt.Graphics2D)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition) throws ResourceAccessException {
		if (image == null) {
			image = Librarian.getInstance().getSprite(spriteCode);
		}
		int x = position.x - scrollPosition;
		if (x < GameProperties.DEFAULT_WIDTH) {
			g.drawImage(image , x, position.y, null);
		}
	}
	
}
