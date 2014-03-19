package com.inpeace.game.item;

import java.awt.Image;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class ItemController {

	/**   */
	private Item item;
	
	/**   */
	private ItemView view;
	
	/**
	 * Constructs a new ItemController object.
	 *
	 * @param item
	 */
	public ItemController(Item item, ItemView itemView) {
		this.item = item;
		this.view = itemView;
	}
	
	/**
	 * 
	 * 
	 * @param glow
	 * @return
	 */
	public Image getImage(boolean glow) {
		if (glow) {
			return item.getGlowing();
		}
		else {
			return item.getNormal();
		}
	}
}
