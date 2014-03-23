package com.inpeace.game.item;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import com.inpeace.game.action.Action;
import com.inpeace.images.ResourceAccessException;
import com.inpeace.images.SpriteLibrarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public abstract class Item {

	/**
	 * Unique code identifying sprite location for the normal graphic of the item.
	 * 
	 * Broken into chunks of 4 digits each, from right to left:
	 * 		Sheet code = the code for the sheet on which the sprite is found
	 * 		x = horizontal position on sheet for top left corner
	 * 		y = vertical position on sheet for top left corner
	 * 		width = sprite box width
	 * 		height = sprite box height
	 * 
	 * NB:	the glowing graphic has to be directly below the normal one on the same
	 * 		sprite sheet
	 */
	private long spriteCode;

	/**   */
	private BufferedImage normal = null;

	/**   */
	private BufferedImage glowing = null;

	/**   */
	ArrayList<Action> actions;

	/**
	 * Constructs a new Item object.
	 *
	 * @param id
	 * @param actions
	 */
	public Item(long spriteCode, ArrayList<Action> actions) {
		this.spriteCode = spriteCode;
		this.actions.addAll(actions);
	}

	/**
	 * Get the sprite code
	 *
	 * @return the sprite code
	 */
	public long getSpriteCode() {
		return spriteCode;
	}
	
	/**
	 * 
	 * 
	 * @param glowing
	 * @return
	 * @throws ResourceAccessException 
	 */
	public static Image getImage(Item item, boolean glowing) throws ResourceAccessException {
		if (glowing) {
			return item.getGlowing();
		}
		else {
			return item.getNormal();
		}
	}
	

	/**
	 * Get the normal
	 *
	 * @return the normal
	 * @throws ResourceAccessException 
	 */
	private BufferedImage getNormal() throws ResourceAccessException {
		if (normal == null) {
			normal = SpriteLibrarian.getInstance().getSprite(spriteCode);
		}
		return normal;
	}

	/**
	 * Get the glowing
	 *
	 * @return the glowing
	 * @throws ResourceAccessException 
	 */
	private BufferedImage getGlowing() throws ResourceAccessException {
		if (glowing == null) {
			glowing = SpriteLibrarian.getInstance().getSprite(spriteCode +
					((spriteCode / 1000000000000L) * 1000000));
		}
		return glowing;
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

}
