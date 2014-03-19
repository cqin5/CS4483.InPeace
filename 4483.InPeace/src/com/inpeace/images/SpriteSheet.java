package com.inpeace.images;

import java.awt.image.BufferedImage;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class SpriteSheet {
	
	/**   */
	private BufferedImage spriteSheet;

	/**
	 * Constructs a new SpriteSheet object.
	 *
	 * @param sheet
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.spriteSheet = sheet;
	}
	
	/**
	 * 
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
}
