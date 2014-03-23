package com.inpeace.images;

import java.awt.image.BufferedImage;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class SpriteLibrarian {

	/**   */
	private static SpriteLibrarian instance = null;

	/**   */
	private SpriteLibrary library;

	/**
	 * Constructs a new SpriteLibrarian object.
	 *
	 */
	private SpriteLibrarian() {
		library = new SpriteLibrary();
	}

	/**
	 * @return
	 */
	public static SpriteLibrarian getInstance() {
		if (instance == null) {
			instance = new SpriteLibrarian();
		}
		return instance;
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(long spriteCode) throws ResourceAccessException {
		return library.getSheet(spriteCode);
	}
	
	/**
	 * @param sheetCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(int sheetCode) throws ResourceAccessException {
		return library.getSheet(sheetCode);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getSprite(long spriteCode) throws ResourceAccessException {
		return getSheet(spriteCode).getSprite(spriteCode);
	}

}
