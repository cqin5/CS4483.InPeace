package com.inpeace.images;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class BackgroundLibrary {

	/**   */
	private final String backgroundPath = "/com/inpeace/images/backgrounds/";
	
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
	 * @param code
	 * @throws ResourceAccessException
	 */
	private void add(String name) throws ResourceAccessException {
		name.toLowerCase();
		library.put(name, BufferedImageLoader.loadImage(backgroundPath + name + ".jpg"));
	}
	
}
