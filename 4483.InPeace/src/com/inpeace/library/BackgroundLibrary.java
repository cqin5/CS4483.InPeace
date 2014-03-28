package com.inpeace.library;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.BufferedImageLoader;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class BackgroundLibrary {

	/**   */
	private static final String backgroundPath = "/com/inpeace/images/backgrounds/";
	
	/**   */
	HashMap<String, BufferedImage> library;
		
	/**
	 * Constructs a new SpriteLibrary object.
	 *
	 */
	public BackgroundLibrary() {
		library = new HashMap<String, BufferedImage>();
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws ResourceAccessException
	 */
	public BufferedImage get(String name) throws ResourceAccessException {
		BufferedImage background = null;
		if (name.equals("")) {
			return null;
		}
		name.toLowerCase();
		background = library.get(name);
		if (background == null) {
			add(name);
			return get(name);
		}
		return background;
	}
	
	/**
	 * 
	 * @param name
	 * @throws ResourceAccessException
	 */
	private void add(String name) throws ResourceAccessException {
		library.put(name, BufferedImageLoader.loadImage(backgroundPath + name + ".jpg"));
	}
	
}
