package com.inpeace.models;

import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
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
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setCharacterEntity(SimpleEntry<Integer, AbstractEntityGraphic> entity)
			throws IncompatibleObjectException {
		if (characters.containsKey(entity.getKey())) {
			addCharacterEntity((ImageEntityGraphic) (entity.getValue()), entity.getKey());
		}
		else {
			if (entity.getValue() == null) {
				removeCharacterEntity(entity.getKey());
			}
			else {
				updateCharacterEntity((ImageEntityGraphic) (entity.getValue()), entity.getKey());
			}
		}
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	private void addCharacterEntity(ImageEntityGraphic graphic, int depth) {
		Iterator<Entry<Integer, ImageEntityGraphic>> old = getCharacterIterator();
		characters.put(depth, graphic);
		fireChange(GraphicsController.CHARACTER_ITERATOR, old, getCharacterIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void removeCharacterEntity(int depth) {
		Iterator<Entry<Integer, ImageEntityGraphic>> old = getCharacterIterator();
		characters.remove(depth);
		fireChange(GraphicsController.CHARACTER_ITERATOR, old, getCharacterIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateCharacterEntity(ImageEntityGraphic graphic, int depth) 
			throws IncompatibleObjectException {
		Iterator<Entry<Integer, ImageEntityGraphic>> old = getCharacterIterator();
		if (characters.get(depth).update(graphic)) {
			fireChange(GraphicsController.CHARACTER_ITERATOR, old, getCharacterIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, ImageEntityGraphic>> getCharacterIterator() {
		return characters.entrySet().iterator();
	}
	
	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setForegroundObjectEntity(SimpleEntry<Integer, ImageEntityGraphic> entity)
			throws IncompatibleObjectException {
		if (objects.containsKey(entity.getKey())) {
			addObjectEntity(entity.getValue(), entity.getKey());
		}
		else {
			if (entity.getValue() == null) {
				removeObjectEntity(entity.getKey());
			}
			else {
				updateObjectEntity(entity.getValue(), entity.getKey());
			}		
		}
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	private void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		objects.put(depth, graphic);
		fireChange(GraphicsController.FOREGROUND_OBJECT_ITERATOR, old, getObjectIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void removeObjectEntity(int depth) {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		objects.remove(depth);
		fireChange(GraphicsController.FOREGROUND_OBJECT_ITERATOR, old, getObjectIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		if (objects.get(depth).update(graphic)) {
			fireChange(GraphicsController.FOREGROUND_OBJECT_ITERATOR, old, getObjectIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, AbstractEntityGraphic>> getObjectIterator() {
		return objects.entrySet().iterator();
	}
	
}
