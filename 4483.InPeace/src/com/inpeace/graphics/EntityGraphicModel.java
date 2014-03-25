package com.inpeace.graphics;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class EntityGraphicModel extends AbstractModel {

	/**   */
	private BufferedImage image;
	
	/**   */
	private Point position;
	
	public EntityGraphicModel(BufferedImage image, Point position) {
		this.image = image;
		this.position = position;
	}

	/**
	 * Get the image
	 *
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Set the image
	 *
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		if (this.image != image) {
			this.image = image;
			//TODO: add fireChange(), do I have to send a copy of the image??
		}
		
	}

	/**
	 * Get the position
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Set the position
	 *
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		if (this.position != position) {
			Point old = this.position;
			this.position = position;
			fireChange("Position", old, position);
		}
	}
	
}
