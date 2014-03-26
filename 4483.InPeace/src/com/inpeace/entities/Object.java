package com.inpeace.entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import com.inpeace.actions.Action;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public abstract class Object {

	/**
	 * Unique code identifying sprite location for the normal graphic of the item.
	 * 
	 * Broken into chunks separated by '-', the chunks are (from left to right):
	 * 		Sheet code = the code for the sheet on which the sprite is found
	 * 		x = horizontal position on sheet for top left corner
	 * 		y = vertical position on sheet for top left corner
	 * 		width = sprite box width
	 * 		height = sprite box height
	 * 
	 * NB:	the glowing versions of each graphic should be directly below the normal one on the same
	 * 		sprite sheet
	 */
	private String spriteCode;

	/**   */
	private BufferedImage dormant = null;

	/**   */
	private BufferedImage active = null;

	/**   */
	ArrayList<Action> actions;

	/**
	 * Constructs a new Item object.
	 *
	 * @param id
	 * @param actions
	 */
	public Object(String spriteCode, ArrayList<Action> actions) {
		this.spriteCode = spriteCode;
		this.actions.addAll(actions);
	}

	/**
	 * Get the sprite code
	 *
	 * @return the sprite code
	 */
	public String getSpriteCode() {
		return spriteCode;
	}
	
	/**
	 * 
	 * 
	 * @param glowing
	 * @return
	 * @throws ResourceAccessException 
	 */
	public static Image getImage(Object item, boolean glowing) throws ResourceAccessException {
		if (glowing) {
			return item.getActive();
		}
		else {
			return item.getDormant();
		}
	}
	

	/**
	 * Get the normal
	 *
	 * @return the normal
	 * @throws ResourceAccessException 
	 */
	private BufferedImage getDormant() throws ResourceAccessException {
		if (dormant == null) {
			dormant = Librarian.getInstance().getSprite(spriteCode);
		}
		return dormant;
	}

	/**
	 * Get the glowing
	 *
	 * @return the glowing
	 * @throws ResourceAccessException 
	 */
	private BufferedImage getActive() throws ResourceAccessException {
		if (active == null) {
			//TODO: determine what to do about different images
		}
		return active;
	}

	/**
	 * 
	 * @param index
	 * @return
	 * @throws
	 */
	public Action getAction(int index) throws IndexOutOfBoundsException {
		if (index > 0 && index < actions.size()) {
			return actions.get(index);
		}
		throw new IndexOutOfBoundsException("Unable to get action: index out of bounds");
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<Action> actionIterator() {
		return actions.iterator();
	}

	/**
	 * @return
	 */
	public abstract boolean isCollectible();
	
	/**
	 * @return
	 */
	public abstract boolean isInstant();

}
