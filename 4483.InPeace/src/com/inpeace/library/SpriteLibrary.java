package com.inpeace.library;

import java.util.HashMap;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.BufferedImageLoader;
import com.inpeace.graphics.SpriteCode;
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
	private static final String spritePath = "/com/inpeace/images/sprites/";

	/**   */
	private HashMap<Integer, SpriteSheet> library;

	/**
	 * Constructs a new SpriteLibrary object.
	 *
	 */
	public SpriteLibrary() {
		library = new HashMap<Integer, SpriteSheet>();
	}

	/**
	 * @param code
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSheet(SpriteCode code) throws ResourceAccessException {
		if (!library.containsKey(code.sheet)) {
			add(code);
		}
		return library.get(code.sheet);
	}

	/**
	 * @param code
	 * @throws ResourceAccessException
	 */
	private void add(SpriteCode code) throws ResourceAccessException {
		library.put(code.sheet, new SpriteSheet(BufferedImageLoader.loadImage(
				spritePath + code.sheet + ".png")));
	}
	

}
