package com.inpeace.graphics;

import java.awt.image.BufferedImage;

import com.inpeace.exceptions.SpriteCodeException;

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
	 * @param spriteCode
	 * @return
	 */
	public BufferedImage getSprite(SpriteCode code) {
		return spriteSheet.getSubimage(code.x, code.y, code.width, code.height);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws SpriteCodeException 
	 */
	public BufferedImage getSprite(String spriteCode) throws SpriteCodeException {
		return getSprite(SpriteCode.get(spriteCode));
	}
}
