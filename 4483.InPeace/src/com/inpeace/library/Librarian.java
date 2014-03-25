package com.inpeace.library;

import java.awt.image.BufferedImage;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteSheet;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class Librarian {

	/**   */
	private static Librarian instance = null;

	/**   */
	private SpriteLibrary sprites;
	
	/**   */
	private BackgroundLibrary backgrounds;

	/**
	 * Constructs a new SpriteLibrarian object.
	 *
	 */
	private Librarian() {
		sprites = new SpriteLibrary();
		backgrounds = new BackgroundLibrary();
	}

	/**
	 * @return
	 */
	public static Librarian getInstance() {
		if (instance == null) {
			instance = new Librarian();
		}
		return instance;
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSpriteSheet(long spriteCode) throws ResourceAccessException {
		return sprites.getSheet(spriteCode);
	}
	
	/**
	 * @param sheetCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSpriteSheet(int sheetCode) throws ResourceAccessException {
		return sprites.getSheet(sheetCode);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getSprite(long spriteCode) throws ResourceAccessException {
		return getSpriteSheet(spriteCode).getSprite(spriteCode);
	}
	
	/**
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getBackground(String name) throws ResourceAccessException {
		return backgrounds.get(name);
	}

}
