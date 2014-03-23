package com.inpeace.game.item;

import java.util.ArrayList;

import com.inpeace.game.action.Action;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class UsableItem extends Item {

	/**
	 * Constructs a new ActionableItem object.
	 *
	 * @param id
	 * @param actions
	 */
	public UsableItem(int id, ArrayList<Action> actions) {
		super(id, actions);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#isCollectible()
	 */
	@Override
	public boolean isCollectible() {
		return false;
	}

}
