package com.inpeace.game.action;

import com.inpeace.objects.Object;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class CollectAction extends Action {
	
	public CollectAction(Object item) {
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
