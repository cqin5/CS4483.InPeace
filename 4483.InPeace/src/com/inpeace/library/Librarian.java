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
	public SpriteSheet getSpriteSheet(String spriteCode) throws ResourceAccessException {
		return sprites.getSheet(spriteCode);
	}
	
	/**
	 * @param sheetNum
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSpriteSheet(int sheetNum) throws ResourceAccessException {
		return sprites.getSheet(sheetNum);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getSprite(String spriteCode) throws ResourceAccessException {
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
