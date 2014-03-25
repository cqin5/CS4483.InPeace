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
	
	/** The name of the background image.  */
	private String name;

	/** The background image graphic.  */
	private BufferedImage background;
	
	/** The horizontal position for scrollable backgrounds.  */
	private int scrollPosition;
	
	/**
	 * Constructs a new BackgroundModel object.
	 *
	 */
	public BackgroundModel() {
		name = "";
		background = null;
		scrollPosition = 0;
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
		if (this.name != name) {
			String old = this.name;
			this.name = name;
			setScrollPosition(0);
			background = null;
			fireChange("BackgroundName", old, name);
		}
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

	/**
	 * Get the scrollPosition
	 *
	 * @return the scrollPosition
	 */
	public int getScrollPosition() {
		return scrollPosition;
	}

	/**
	 * Set the scrollPosition
	 *
	 * @param scrollPosition the scrollPosition to set
	 */
	public void setScrollPosition(int scrollPosition) {
		if (this.scrollPosition != scrollPosition) {
			int old = this.scrollPosition;
			this.scrollPosition = scrollPosition;
			fireChange("BackgroundName", old, name);
		}
	}
	
}
