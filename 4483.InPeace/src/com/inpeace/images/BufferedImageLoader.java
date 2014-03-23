package com.inpeace.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class BufferedImageLoader {

	/**   */
	private static final BufferedImageLoader instance = new BufferedImageLoader();
	
	/**   */
	private static final String imageBasePath = "/com/inpeace/images/";
	
	/**
	 * Constructs a new BufferedImageLoader object.
	 *
	 */
	private BufferedImageLoader() {
		//NULL BODY
	}
	
	/**
	 * @return
	 */
	public static BufferedImageLoader getInstance() {
		return instance;
	}
	
	/**
	 * @param relativePath
	 * @return
	 * @throws ResourceAccessException 
	 */
	public BufferedImage loadImage(String relativePath) throws ResourceAccessException {
		BufferedImage img;
		try {
			img = ImageIO.read(getClass().getResource(imageBasePath + relativePath));
		} catch (IOException e) {
			throw new ResourceAccessException("Opps! It appears we were "
					+ "unable to load the image: " + relativePath + " (BufferedImageLoader");
		}
		return img;
	}
	
}
