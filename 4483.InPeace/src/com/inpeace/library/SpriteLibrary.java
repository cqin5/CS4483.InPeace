package com.inpeace.library;

import java.util.HashMap;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.BufferedImageLoader;
import com.inpeace.graphics.SpriteSheet;

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
	 * @param sheetNum
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(int sheetNum) throws ResourceAccessException {
		SpriteSheet sheet = null;
		sheet = library.get(sheetNum);
		if (sheet == null) {
			add(sheetNum);
			return getSheet(sheetNum);
		}
		return sheet;
	}

	/**
	 * 
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(String spriteCode) throws ResourceAccessException {
		if (spriteCode.equals("")) {
			return null;
		}
		try {
			String[] chunks = spriteCode.split("-");
			return getSheet(Integer.parseInt(chunks[0]));
		} catch (NumberFormatException e) {
			throw new ResourceAccessException("Opps! It seems " + spriteCode 
					+ " is not a valid spriteCode:(  (SpriteLibrary)");
		}
	}

	/**
	 * 
	 * @param sheetNum
	 * @throws ResourceAccessException
	 */
	private void add(int sheetNum) throws ResourceAccessException {
		library.put(sheetNum, new SpriteSheet(BufferedImageLoader.loadImage(
				spritePath + sheetNum + ".png")));
	}

}
