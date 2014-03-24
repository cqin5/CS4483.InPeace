package com.inpeace.objects;

import java.util.ArrayList;

import com.inpeace.actions.Action;
import com.inpeace.actions.CollectAction;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class CollectibleItem extends Object {

	/**
	 * Constructs a new CollectibleItem object.
	 *
	 */
	public CollectibleItem(int id) {
		super(id, new ArrayList<Action>());
		actions.add(new CollectAction(this));
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#isCollectible()
	 */
	@Override
	public boolean isCollectible() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.objects.Object#isInstant()
	 */
	@Override
	public boolean isInstant() {
		// TODO Auto-generated method stub
		return false;
	}

}
