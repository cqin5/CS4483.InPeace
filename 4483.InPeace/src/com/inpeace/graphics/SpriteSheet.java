package com.inpeace.graphics;

import java.awt.image.BufferedImage;

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
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
	
	/**
	 * @param spriteCode
	 * @return
	 */
	public BufferedImage getSprite(String spriteCode) {
		String[] chuncks = spriteCode.split("-");
		int x = Integer.parseInt(chuncks[1]);
		System.out.print(x + "\n");
		int y = Integer.parseInt(chuncks[2]);
		System.out.print(y + "\n");
		int width = Integer.parseInt(chuncks[3]);
		System.out.print(width + "\n");
		int height = Integer.parseInt(chuncks[4]);
		System.out.print(height + "\n");

		return getSprite((int) x, y, width, height);
	}
}
