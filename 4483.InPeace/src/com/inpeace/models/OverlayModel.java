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
 * @since   18 Mar 2014
 */
public class OverlayModel extends AbstractModel {

	/**   */
	private long spriteCode;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayModel() {
		spriteCode = 0;
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * @return
	 */
	public long getOverlaySpriteCode() {
		return spriteCode;
	}

	/**
	 * @param name
	 */
	public void setOverlaySpriteCode(long name) {
		if (this.spriteCode != name) {
			long old = this.spriteCode;
			this.spriteCode = name;
			fireChange(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, old, name);
		}
	}
	
	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setOverlayObjectEntity(SimpleEntry<Integer, ImageEntityGraphic> entity)
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
		fireChange(GraphicsController.OVERLAY_OBJECT_ITERATOR, old, getObjectIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void removeObjectEntity(int depth) {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		objects.remove(depth);
		fireChange(GraphicsController.OVERLAY_OBJECT_ITERATOR, old, getObjectIterator());
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
			fireChange(GraphicsController.OVERLAY_OBJECT_ITERATOR, old, getObjectIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, AbstractEntityGraphic>> getObjectIterator() {
		return objects.entrySet().iterator();
	}
	
}

