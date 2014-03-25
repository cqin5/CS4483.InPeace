package com.inpeace.models;

import java.awt.image.BufferedImage;

import com.inpeace.controllers.GraphicsController;
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
	private String backgroundName;
	
	/** The horizontal position for scrollable backgrounds.  */
	private int scrollPosition;
	
	/**
	 * Constructs a new BackgroundModel object.
	 *
	 */
	public BackgroundModel() {
		backgroundName = "";
		scrollPosition = 0;
	}

	/**
	 * Get the name
	 *
	 * @return the name
	 */
	public String getBackgroundName() {
		return backgroundName;
	}

	/**
	 * Set the name
	 *
	 * @param name the name to set
	 */
	public void setBackgroundName(String name) {
		if (this.backgroundName != name) {
			String old = this.backgroundName;
			this.backgroundName = name;
			setScrollPosition(0);
			fireChange(GraphicsController.BACKGROUND_IMAGE_NAME, old, name);
		}
	}

	/**
	 * Get the background
	 *
	 * @return the background
	 * @throws ResourceAccessException 
	 */
	public BufferedImage getBackground() throws ResourceAccessException {
		return Librarian.getInstance().getBackground(backgroundName);
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
			fireChange(GraphicsController.HORIZONTAL_SCROLL_POSITION, old, scrollPosition);
		}
	}
	
}
