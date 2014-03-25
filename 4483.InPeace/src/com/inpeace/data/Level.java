package com.inpeace.data;

import java.io.Serializable;
import java.util.ArrayList;

import com.inpeace.entities.Object;

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
	private ArrayList<Character> characters;
	
	/**   */
	private ArrayList<Object> objects;

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
	public ArrayList<Object> getItems() {
		return objects;
	}

	/**
	 * Set the items
	 *
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Object> items) {
		this.objects = items;
	}
	
	
}
