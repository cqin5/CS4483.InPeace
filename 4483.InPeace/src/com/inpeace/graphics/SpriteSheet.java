package com.inpeace.graphics;

import java.awt.image.BufferedImage;

import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
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
	private BufferedImage getSprite(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException 
	 */
	public BufferedImage getSprite(String spriteCode) throws ResourceAccessException {
		try {
			String[] chuncks = spriteCode.split("-");
			int x = Integer.parseInt(chuncks[1]);
			int y = Integer.parseInt(chuncks[2]);
			int width = Integer.parseInt(chuncks[3]);
			int height = Integer.parseInt(chuncks[4]);

			return getSprite((int) x, y, width, height);
		} catch (NumberFormatException e) {
			throw new ResourceAccessException("Opps! It seems " + spriteCode 
					+ " is not a valid spriteCode:(  (SpriteSheet)");
		}
	}
}
