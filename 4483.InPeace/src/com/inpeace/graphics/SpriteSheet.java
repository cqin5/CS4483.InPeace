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
	
	/**
	 * @param spriteCode
	 * @param rowsDown
	 * @param columnsAcross
	 * @return
	 */
	public static String convertCode(String spriteCode, int rowsDown, int columnsAcross) {
		try {
			String[] chunks = spriteCode.split("-");
			int x = Integer.parseInt(chunks[1]);
			int y = Integer.parseInt(chunks[2]);
			int width = Integer.parseInt(chunks[3]);
			int height = Integer.parseInt(chunks[4]);
			
			chunks[1] = Integer.toString(x + (columnsAcross * width));
			chunks[2] = Integer.toString(y + (rowsDown * height));
			
			return chunks[0] + "-" + chunks[1] + "-" + chunks[2] + "-" + chunks[3] + "-" + chunks[4];
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * @param spriteCode
	 * @return
	 */
	public static int getSpriteWidth(String spriteCode) {
		try {
			String[] chunks = spriteCode.split("-");
			return Integer.parseInt(chunks[3]);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
