package com.inpeace.game.item;

import java.awt.Image;
import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class ActionableItem implements Item {

	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#getItemID()
	 */
	@Override
	public int getItemID() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#getImage(int)
	 */
	@Override
	public Image getImage(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#isCollectible()
	 */
	@Override
	public boolean isCollectible() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.game.item.Item#getActions()
	 */
	@Override
	public ArrayList<Action> getActions() {
		// TODO Auto-generated method stub
		return null;
	}

}
