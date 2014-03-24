package com.inpeace.graphics;

import java.awt.image.BufferedImage;

import com.inpeace.Librarian;
import com.inpeace.images.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class BackgroundModel extends AbstractModel {
	
	/**   */
	private String name;

	/**   */
	private BufferedImage background;
	
	/**
	 * Constructs a new BackgroundModel object.
	 *
	 */
	public BackgroundModel() {
		name = "splash"; //TODO: add way to load proper code
		background = null;
	}

	/**
	 * Get the name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name
	 *
	 * @param name the name to set
	 */
	public void setBackgroundName(String name) {
		String old = this.name;
		if (this.name != name) {
			this.name = name;
			background = null;
		}
		fireChange("BackgroundName", old, name);
	}

	/**
	 * Get the background
	 *
	 * @return the background
	 * @throws ResourceAccessException 
	 */
	public BufferedImage getBackground() throws ResourceAccessException {
		if (background == null) {
			Librarian.getInstance().getBackground(name);
		}
		return background;
	}
	
}
