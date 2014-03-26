package com.inpeace.entities;

import java.util.ArrayList;

import com.inpeace.actions.Action;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   23 Mar 2014
 */
public class ButtonObject extends Object {

	/**
	 * Constructs a new ButtonObject object.
	 *
	 * @param spriteCode
	 * @param actions
	 */
	public ButtonObject(String spriteCode, ArrayList<Action> actions) {
		super(spriteCode, actions);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.inpeace.objects.Object#isCollectible()
	 */
	@Override
	public boolean isCollectible() {
		// TODO Auto-generated method stub
		return false;
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
