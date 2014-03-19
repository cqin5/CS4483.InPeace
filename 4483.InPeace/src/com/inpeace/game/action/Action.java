package com.inpeace.game.action;

import com.inpeace.game.item.Item;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public abstract class Action {
	
	/**   */
	protected Item item;
	
	/**
	 * Constructs a new Action object.
	 *
	 * @param item
	 */
	public Action(Item item) {
		setItem(item);
	}
	
	/**
	 * 
	 */
	public abstract void performAction();

	/**
	 * Get the item
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Set the item
	 *
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
}
