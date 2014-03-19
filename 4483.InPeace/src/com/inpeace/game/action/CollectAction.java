package com.inpeace.game.action;

import com.inpeace.game.item.Item;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class CollectAction extends Action {
	
	CollectAction(Item item) {
		super(item);
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Action#performAction()
	 */
	@Override
	public void performAction() {
		//TODO: add code to set the item to disappear and to add the item to the players collectible
	}
}
