package com.inpeace.models;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.graphics.AbstractEntityGraphic;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class OverlayModel extends AbstractModel {

	/**   */
	private String spriteCode;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayModel() {
		spriteCode = "";
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * @return
	 */
	public String getOverlaySpriteCode() {
		return spriteCode;
	}

	/**
	 * @param spriteCode
	 */
	public void setOverlaySpriteCode(String spriteCode) {
		if (this.spriteCode != spriteCode) {
			String old = this.spriteCode;
			this.spriteCode = spriteCode;
			fireChange(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, old, spriteCode);
		}
	}
	
	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setOverlayObjectEntity(AbstractEntityGraphic entity)
			throws IncompatibleObjectException {
		if (objects.containsKey(entity.getDepth())) {
			addObjectEntity(entity, entity.getDepth());
		}
		else {
			if (entity.getDepth() < 0) {
				removeObjectEntity(-(entity.getDepth()));
			}
			else {
				updateObjectEntity(entity, entity.getDepth());
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

