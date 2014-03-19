package com.inpeace.game.item;

import java.awt.Image;
import java.util.ArrayList;

import com.inpeace.game.action.Action;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public abstract class Item {

	/**   */
	private int id;
	
	/**   */
	private Image normal = null;
	
	/**   */
	private Image glowing = null;
	
	/**   */
	ArrayList<Action> actions;
	
	/**
	 * Constructs a new Item object.
	 *
	 * @param id
	 * @param actions
	 */
	public Item(int id, ArrayList<Action> actions) {
		setId(id);
		setActions(actions);
		
	}
	
	/**
	 * Get the id
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id
	 *
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the normal
	 *
	 * @return the normal
	 */
	public Image getNormal() {
		if (normal == null) {
			setNormal(null); //TODO: add proper image parameter to this line
		}
		return normal;
	}

	/**
	 * Set the normal
	 *
	 * @param normal the normal to set
	 */
	private void setNormal(Image normal) {
		this.normal = normal;
	}
	
	/**
	 * Get the glowing
	 *
	 * @return the glowing
	 */
	public Image getGlowing() {
		if (glowing == null) {
			setGlowing(null); //TODO: add proper image parameter to this line
		}
		return glowing;
	}

	/**
	 * Set the glowing
	 *
	 * @param glowing the glowing to set
	 */
	private void setGlowing(Image glowing) {
		this.glowing = glowing;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws
	 */
	public Action getAction(int index) {
		if (index > 0 && index < actions.size()) {
			return actions.get(index);
		}
		throw new IndexOutOfBoundsException();
	}


	/**
	 * Set the actions
	 * 
	 * @param actions the actions to set
	 */
	public void setActions(ArrayList<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			this.actions.add(actions.get(i));
		}
	}

	/**
	 * @return
	 */
	public abstract boolean isCollectible();
	
}
