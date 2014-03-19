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
public interface Item {

	public int getItemID();
	
	public Image getImage(int state); //possible states 0=normal, 1=glowing

	public boolean isCollectible();
	
	public ArrayList<Action> getActions();
	
	//TODO: Add other methods relating to items
}
