package com.inpeace.level;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.game.item.Item;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class Level implements Serializable {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -7604971177826975662L;

	/**   */
	private String backgroundPath;
	
	/**   */
	private ArrayList<Character> characters;
	
	/**   */
	private ArrayList<Item> items;

	/**
	 * Get the backgroundPath
	 *
	 * @return the backgroundPath
	 */
	public String getBackgroundPath() {
		return backgroundPath;
	}

	/**
	 * Set the backgroundPath
	 *
	 * @param backgroundPath the backgroundPath to set
	 */
	public void setBackgroundPath(String backgroundPath) {
		this.backgroundPath = backgroundPath;
	}

	/**
	 * Get the characters
	 *
	 * @return the characters
	 */
	public ArrayList<Character> getCharacters() {
		return characters;
	}

	/**
	 * Set the characters
	 *
	 * @param characters the characters to set
	 */
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}

	/**
	 * Get the items
	 *
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Set the items
	 *
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
}
