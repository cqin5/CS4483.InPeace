package com.inpeace.images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class BufferedImageLoader {

	/**
	 * @param relativePath
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage loadImage(String relativePath) throws IOException {
		URL url = BufferedImageLoader.class.getClassLoader().getResource(relativePath);
		BufferedImage img = ImageIO.read(url);
		return img;
	}
	
}
