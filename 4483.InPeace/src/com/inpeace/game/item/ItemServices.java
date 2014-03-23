package com.inpeace.game.item;

import java.awt.Image;
import java.util.Iterator;

import com.inpeace.game.action.Action;
import com.inpeace.images.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   19 Mar 2014
 */
public abstract class ItemServices {

	/**   */
	private Item item;
	
	/**
	 * Constructs a new ItemController object.
	 *
	 * @param item
	 */
	public ItemServices(Item item) {
		this.item = item;
	}
	
	/**
	 * 
	 * 
	 * @param glowing
	 * @return
	 * @throws ResourceAccessException 
	 */
	public Image getImage(boolean glowing) throws ResourceAccessException {
		if (glowing) {
			return item.getGlowing();
		}
		else {
			return item.getNormal();
		}
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws
	 */
	public Action getAction(int index) throws IndexOutOfBoundsException {
		return item.getAction(index);
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<Action> actionIterator() {
		return item.actionIterator();
	}

	/**
	 * @return
	 */
	public abstract boolean isCollectible();
}
