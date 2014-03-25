package com.inpeace.graphics;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ForegroundModel extends AbstractModel {

	/**   */
	private TreeMap<Integer, EntityGraphicModel> characters;
	
	/**   */
	private TreeMap<Integer, EntityGraphicModel> objects;
	
	/**
	 * Constructs a new ForegroundModel object.
	 *
	 */
	public ForegroundModel() {
		characters = new TreeMap<Integer, EntityGraphicModel>();
		objects = new TreeMap<Integer, EntityGraphicModel>();
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void addCharacterEntity(EntityGraphicModel graphic, int depth) {
		Iterator<Entry<Integer, EntityGraphicModel>> old = getCharacterIterator();
		characters.put(depth, graphic);
		fireChange("CharacterIterator", old, getCharacterIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void updateCharacterEntity(EntityGraphicModel graphic, int depth) {
		characters.remove(depth);
		addCharacterEntity(graphic, depth);
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, EntityGraphicModel>> getCharacterIterator() {
		return characters.entrySet().iterator();
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void addObjectEntity(EntityGraphicModel graphic, int depth) {
		Iterator<Entry<Integer, EntityGraphicModel>> old = getCharacterIterator();
		characters.put(depth, graphic);
		fireChange("ObjectIterator", old, getCharacterIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void updateObjectEntity(EntityGraphicModel graphic, int depth) {
		objects.remove(depth);
		addObjectEntity(graphic, depth);
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, EntityGraphicModel>> getObjectIterator() {
		return objects.entrySet().iterator();
	}
	
}
