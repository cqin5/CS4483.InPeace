package com.inpeace.entities;

import java.util.ArrayList;

import com.inpeace.actions.AbstractAction;
import com.inpeace.actions.CollectAction;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class CollectibleItem extends Object {

	/**
	 * Constructs a new CollectibleItem object.
	 *
	 */
	public CollectibleItem(String id) {
		super(id, new ArrayList<AbstractAction>());
		actions.add(new CollectAction());
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
