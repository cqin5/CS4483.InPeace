package com.inpeace.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Loads bundled project resource images as buffered images.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   19 Mar 2014
 */
public final class BufferedImageLoader {
	
	/** Base path to images for current project.  */
	private static final String imageBasePath = "/com/inpeace/images/";
	
	/**
	 * @param relativePath				the relative path from the image base directory.
	 * @return							the loaded buffered image.
	 * @throws ResourceAccessException	the exception thrown when there is an issue accessing
	 * 									the image trying to be loaded.
	 */
	public static BufferedImage loadImage(String relativePath) throws ResourceAccessException {
		BufferedImage img;
		try {
			img = ImageIO.read(BufferedImageLoader.class.getResource(imageBasePath + relativePath));
		} catch (IOException e) {
			throw new ResourceAccessException("Opps! It appears we were "
					+ "unable to load the image: " + relativePath + " (BufferedImageLoader");
		}
		return img;
	}
	
}
