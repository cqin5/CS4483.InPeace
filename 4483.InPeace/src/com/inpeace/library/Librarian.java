package com.inpeace.library;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.exceptions.SpriteCodeException;
import com.inpeace.graphics.SpriteCode;
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
	 * @param sheetNum
	 * @return
	 * @throws ResourceAccessException
	 */
	public SpriteSheet getSpriteSheet(SpriteCode spriteCode) throws ResourceAccessException {
		return sprites.getSheet(spriteCode);
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 * @throws SpriteCodeException
	 */
	public SpriteSheet getSpriteSheet(String spriteCode) 
			throws ResourceAccessException, SpriteCodeException {
		
		return getSpriteSheet(SpriteCode.get(spriteCode));
	}
	
	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getSprite(SpriteCode spriteCode) throws ResourceAccessException {
		SpriteSheet sheet = getSpriteSheet(spriteCode);
		if (sheet != null) {
			return sheet.getSprite(spriteCode);
		}
		return null;
	}
	
	/**
	 * @param spriteCode
	 * @return
	 * @throws ResourceAccessException
	 * @throws SpriteCodeException
	 */
	public BufferedImage getSprite(String spriteCode) 
			throws ResourceAccessException, SpriteCodeException {
		
		return getSprite(SpriteCode.get(spriteCode));
	}
	
	/**
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage getBackground(String name) throws ResourceAccessException {
		return backgrounds.get(name);
	}
	
	/**
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public Clip getSound(String name) throws ResourceAccessException {
		return SoundLibrary.get(name);
	}

}
