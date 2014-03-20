package com.inpeace.level;

import java.awt.image.BufferedImage;
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
	private BufferedImage background;
	
	/**   */
	private ArrayList<Character> characters;
	
	/**   */
	private ArrayList<Item> items;
	
	
}
