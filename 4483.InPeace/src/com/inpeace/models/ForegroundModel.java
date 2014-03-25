package com.inpeace.models;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.graphics.AbstractEntityGraphic;
import com.inpeace.graphics.ImageEntityGraphic;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ForegroundModel extends AbstractModel {

	/**   */
	private TreeMap<Integer, ImageEntityGraphic> characters;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new ForegroundModel object.
	 *
	 */
	public ForegroundModel() {
		characters = new TreeMap<Integer, ImageEntityGraphic>();
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void addCharacterEntity(ImageEntityGraphic graphic, int depth) {
		Iterator<Entry<Integer, ImageEntityGraphic>> old = getCharacterIterator();
		characters.put(depth, graphic);
		fireChange("CharacterIterator", old, getCharacterIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	public void updateCharacterEntity(ImageEntityGraphic graphic, int depth) 
			throws IncompatibleObjectException {
		Iterator<Entry<Integer, ImageEntityGraphic>> old = getCharacterIterator();
		if (characters.get(depth).update(graphic)) {
			fireChange("CharacterIterator", old, getCharacterIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, ImageEntityGraphic>> getCharacterIterator() {
		return characters.entrySet().iterator();
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		objects.put(depth, graphic);
		fireChange("ObjectIterator", old, getObjectIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	public void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		if (objects.get(depth).update(graphic)) {
			fireChange("ObjectIterator", old, getObjectIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, AbstractEntityGraphic>> getObjectIterator() {
		return objects.entrySet().iterator();
	}
	
}
