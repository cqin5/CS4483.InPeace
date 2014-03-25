package com.inpeace.models;

import java.awt.image.BufferedImage;

import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class BackgroundModel extends AbstractModel {
	
	/** The name of the background image.  */
	private String background;
	
	/** The horizontal position for scrollable backgrounds.  */
	private int scrollPosition;
	
	/**
	 * Constructs a new BackgroundModel object.
	 *
	 */
	public BackgroundModel() {
		background = "";
		scrollPosition = 0;
	}

	/**
	 * Get the name
	 *
	 * @return the name
	 */
	public String getBackgroundName() {
		return background;
	}

	/**
	 * Set the name
	 *
	 * @param name the name to set
	 */
	public void setBackground(String name) {
		if (this.background != name) {
			String old = this.background;
			this.background = name;
			setScrollPosition(0);
			fireChange("Background", old, name);
		}
	}

	/**
	 * Get the background
	 *
	 * @return the background
	 * @throws ResourceAccessException 
	 */
	public BufferedImage getBackground() throws ResourceAccessException {
		return Librarian.getInstance().getBackground(background);
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
			fireChange("ScrollPosition", old, scrollPosition);
		}
	}
	
}
