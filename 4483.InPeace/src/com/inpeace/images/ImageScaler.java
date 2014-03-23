package com.inpeace.images;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class ImageScaler {

	/**
	 * @param img
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage qualityScale(BufferedImage img, int width, int height) {

		int w = img.getWidth();
		int h = img.getHeight();

		double factor = 1.0;

		if ((width / w) < (height / h)) {
			factor = (double) width / w;
		}
		else {
			factor = (double) height / h;
		}

		BufferedImage scaled = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		AffineTransform t = new AffineTransform();
		t.scale(factor, factor);
		AffineTransformOp scaleOp = new AffineTransformOp(t, AffineTransformOp.TYPE_BILINEAR);
		scaled = scaleOp.filter(img, scaled);

		return scaled;
	}

	public static BufferedImage scale(BufferedImage img, int width, int height)
	{        
		BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics g = scaled.createGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		g.dispose();
		return scaled;
	}
}
