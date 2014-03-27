package com.inpeace.models;

import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.exceptions.IncompatibleObjectException;

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
	private TreeMap<Integer, AbstractEntity> objects;
	
	/**
	 * Constructs a new ForegroundModel object.
	 *
	 */
	public DefaultGraphicsModel() {
		backgroundName = "";
		scrollPosition = 0;
		stateType = 0;
		objects = new TreeMap<Integer, AbstractEntity>();
	}
	
	/**
	 * Set the state type
	 * 
	 * @param stateType	the state type to set
	 */
	public void setStateType(Integer stateType) {
		if (this.stateType != stateType) {
			this.stateType = stateType;
			fireChange(GraphicsController.STATE_TYPE, stateType);
		}
	}
	
	/**
	 * Set the background name
	 *
	 * @param backgroundName the background name to set
	 */
	public void setBackgroundName(String backgroundName) {
		if (this.backgroundName != backgroundName) {
			this.backgroundName = backgroundName;
			fireChange(GraphicsController.BACKGROUND_IMAGE_NAME, backgroundName);
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
			this.scrollPosition = scrollPosition;
			fireChange(GraphicsController.HORIZONTAL_SCROLL_POSITION, scrollPosition);
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
	public void setForegroundObjectEntity(AbstractEntity entity)
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
			objects.remove(depth);
			fireChange(GraphicsController.FOREGROUND_OBJECTS,
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/**
	 * @param graphic
	 * @param depth
	 */
	private void addObjectEntity(AbstractEntity graphic, int depth) {
		objects.put(depth, graphic);
		fireChange(GraphicsController.FOREGROUND_OBJECTS, 
				new ArrayList<AbstractEntity>(objects.values()));
	}

	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateObjectEntity(AbstractEntity graphic, int depth)
			throws IncompatibleObjectException {
		if (objects.get(depth).update(graphic)) {
			fireChange(GraphicsController.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearForegroundObjects() {
		if (objects != null) {
			objects.clear();
			fireChange(GraphicsController.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(GraphicsController.BACKGROUND_IMAGE_NAME, backgroundName);
		fireChange(GraphicsController.HORIZONTAL_SCROLL_POSITION, scrollPosition);
		fireChange(GraphicsController.FOREGROUND_OBJECTS, new ArrayList<AbstractEntity>());
	}
	
}