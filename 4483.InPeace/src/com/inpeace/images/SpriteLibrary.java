package com.inpeace.images;

import java.util.HashMap;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class SpriteLibrary {
	
	/**   */
	private final String spritePath = "/com/inpeace/images/sprites/";
	
	/**   */
	HashMap<Integer, SpriteSheet> library;
		
	/**
	 * Constructs a new SpriteLibrary object.
	 *
	 */
	public SpriteLibrary() {
		library = new HashMap<Integer, SpriteSheet>();
	}

	/**
	 * 
	 * @param sheetCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(int sheetCode) throws ResourceAccessException {
		SpriteSheet sheet = null;
		sheet = library.get(sheetCode);
		if (sheet == null) {
			add(sheetCode);
			return getSheet(sheetCode);
		}
		return sheet;
	}

	/**
	 * 
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(long spriteCode) throws ResourceAccessException {
		return getSheet(spriteCode % 1000);
	}
	
	/**
	 * 
	 * @param sheetCode
	 * @throws ResourceAccessException
	 */
	private void add(int sheetCode) throws ResourceAccessException {
		library.put(sheetCode, new SpriteSheet(BufferedImageLoader.loadImage(
				spritePath + sheetCode + ".png")));
	}
	
}
