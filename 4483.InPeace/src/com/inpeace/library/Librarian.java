package com.inpeace.library;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

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
	
	/**   */
	private SoundLibrary sounds;

	/**
	 * Constructs a new SpriteLibrarian object.
	 *
	 */
	private Librarian() {
		sprites = new SpriteLibrary();
		backgrounds = new BackgroundLibrary();
		sounds = new SoundLibrary();
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
		SpriteSheet sheet = getSpriteSheet(spriteCode);
		if (sheet != null) {
			return sheet.getSprite(spriteCode);
		}
		return null;
	}
	
	/**
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getBackground(String name) throws ResourceAccessException {
		return backgrounds.get(name);
	}
	
	public Clip getSound(String name) throws ResourceAccessException {
		return sounds.get(name);
	}

}
