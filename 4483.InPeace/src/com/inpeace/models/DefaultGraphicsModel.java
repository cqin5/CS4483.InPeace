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
 * @since   24 Mar 2014
 */
public class DefaultGraphicsModel extends AbstractModel {
	
	/** Type of state (0 = splash, 1 = menu, 2 = in game, 3 = overlay)  */
	private int stateType;
	
	/** The name of the background image.  */
	private String backgroundName;
	
	/** The horizontal position for scrollable views.  */
	private int scrollPosition;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new ForegroundModel object.
	 *
	 */
	public DefaultGraphicsModel() {
		backgroundName = "";
		scrollPosition = 0;
		stateType = 0;
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * Set the state type
	 * 
	 * @param stateType	the state type to set
	 */
	public void setStateType(Integer stateType) {
		if (this.stateType != stateType) {
			int old = this.stateType;
			this.stateType = stateType;
			fireChange(GraphicsController.STATE_TYPE, old, stateType);
		}
	}
	
	/**
	 * Set the background name
	 *
	 * @param backgroundName the background name to set
	 */
	public void setBackgroundName(String backgroundName) {
		if (this.backgroundName != backgroundName) {
			String old = this.backgroundName;
			this.backgroundName = backgroundName;
			fireChange(GraphicsController.BACKGROUND_IMAGE_NAME, old, backgroundName);
		}
	}

	/**
	 * Get the scrollPosition
	 *
	 * @return the scrollPosition
	 */
	public int getScrollPosition() {
		return scrollPosition;
	}

	/**
	 * Set the scrollPosition
	 *
	 * @param scrollPosition the scrollPosition to set
	 */
	public void setScrollPosition(int scrollPosition) {
		if (this.scrollPosition != scrollPosition) {
			int old = this.scrollPosition;
			this.scrollPosition = scrollPosition;
			fireChange(GraphicsController.HORIZONTAL_SCROLL_POSITION, old, scrollPosition);
		}
	}
	
	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setForegroundObjectEntity(AbstractEntityGraphic entity)
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
