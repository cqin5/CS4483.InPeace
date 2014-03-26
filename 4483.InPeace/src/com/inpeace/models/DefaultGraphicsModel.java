package com.inpeace.models;

import java.util.ArrayList;
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
	
	/** Type of state  */
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
	 * 
	 */
	public void clearBackgroundName() {
		setBackgroundName("");
	}

	/**
	 * Get the scrollPosition
	 *
	 * @return the scrollPosition
	 */
	public int getHorizontalScrollPosition() {
		return scrollPosition;
	}

	/**
	 * Set the scrollPosition
	 *
	 * @param scrollPosition the scrollPosition to set
	 */
	public void setHorizontalScrollPosition(Integer scrollPosition) {
		if (this.scrollPosition != scrollPosition) {
			int old = this.scrollPosition;
			this.scrollPosition = scrollPosition;
			fireChange(GraphicsController.HORIZONTAL_SCROLL_POSITION, old, scrollPosition);
		}
	}
	
	/**
	 * 
	 */
	public void clearHorizontalScrollPosition() {
		setHorizontalScrollPosition(0);
	}

	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setForegroundObjectEntity(AbstractEntityGraphic entity)
			throws IncompatibleObjectException {
		if (!objects.containsKey(entity.getDepth())) {
			addObjectEntity(entity, entity.getDepth());
		}
		else {
			updateObjectEntity(entity, entity.getDepth());		
		}
	}
	
	/**
	 * @param depth
	 */
	public void clearForegroundObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			ArrayList<AbstractEntityGraphic> old = 
					new ArrayList<AbstractEntityGraphic>(objects.values());
			objects.remove(depth);
			fireChange(GraphicsController.FOREGROUND_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * @param graphic
	 * @param depth
	 */
	private void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		ArrayList<AbstractEntityGraphic> old = 
				new ArrayList<AbstractEntityGraphic>(objects.values());
		objects.put(depth, graphic);
		fireChange(GraphicsController.FOREGROUND_OBJECTS, old, 
				new ArrayList<AbstractEntityGraphic>(objects.values()));
	}

	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		ArrayList<AbstractEntityGraphic> old = 
				new ArrayList<AbstractEntityGraphic>(objects.values());
		if (objects.get(depth).update(graphic)) {
			fireChange(GraphicsController.FOREGROUND_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearForegroundObjects() {
		if (objects != null) {
			ArrayList<AbstractEntityGraphic> old = 
					new ArrayList<AbstractEntityGraphic>(objects.values());
			objects.clear();
			fireChange(GraphicsController.FOREGROUND_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>());
		}
	}
	
}
