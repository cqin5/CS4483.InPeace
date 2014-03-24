package com.inpeace.actions;

import com.inpeace.objects.Object;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public abstract class Action {
	
	/**   */
	protected Object item;
	
	/**
	 * Constructs a new Action object.
	 *
	 * @param item
	 */
	public Action(Object item) {
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
	public Object getItem() {
		return item;
	}
	
	/**
	 * Set the item
	 *
	 * @param item the item to set
	 */
	public void setItem(Object item) {
		this.item = item;
	}
}
