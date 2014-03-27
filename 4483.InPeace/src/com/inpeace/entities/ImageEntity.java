package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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
public class ImageEntity extends AbstractEntity {
	
	/**   */
	private String spriteCode;
	
	/**   */
	private BufferedImage image;
	
	/**   */
	private Point position;
	
	public ImageEntity(int depth, int clickActionCode, String spriteCode, Point position) {
		super(depth, clickActionCode);
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
	public boolean update(AbstractEntity graphic) throws IncompatibleObjectException {
		if (graphic.getClass() != ImageEntity.class) {
			throw new IncompatibleObjectException("ImageEntityGraphic: unable to update,"
					+ " paramater class does not match");
		}
		boolean change = false;
		if (spriteCode != ((ImageEntity) graphic).getSpriteCode()) {
			spriteCode = ((ImageEntity) graphic).getSpriteCode();
			change = true;
		}
		if (position != ((ImageEntity) graphic).getPosition()) {
			position = ((ImageEntity) graphic).getPosition();
			change = true;
		}
		if (change) {
			String[] chunks = spriteCode.split("-");
			bounds = new Rectangle(position.x, position.y, Integer.parseInt(chunks[3]), 
					Integer.parseInt(chunks[4]));
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
