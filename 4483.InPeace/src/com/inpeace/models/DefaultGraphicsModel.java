package com.inpeace.models;

import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.DefaultController;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.states.AbstractState;

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
			fireChange(AbstractState.STATE_TYPE, stateType);
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
			fireChange(DefaultController.BACKGROUND_IMAGE_NAME, backgroundName);
		}
	}
	
	/**
	 * 
	 */
	public void clearBackgroundName() {
		setBackgroundName("");
	}

	/**
	 * Set the scrollPosition
	 *
	 * @param scrollPosition the scrollPosition to set
	 */
	public void setHorizontalScrollPosition(Integer scrollPosition) {
		if (this.scrollPosition != scrollPosition) {
			this.scrollPosition = scrollPosition;
			fireChange(DefaultController.HORIZONTAL_SCROLL_POSITION, scrollPosition);
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
	 */
	public void setForegroundObjectEntity(AbstractEntity entity) {
		objects.put(entity.getDepth(), entity);
		fireChange(DefaultController.FOREGROUND_OBJECTS, 
				new ArrayList<AbstractEntity>(objects.values()));
	}
	
	/**
	 * @param depth
	 */
	public void clearForegroundObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			objects.remove(depth);
			fireChange(DefaultController.FOREGROUND_OBJECTS,
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearForegroundObjects() {
		if (objects != null) {
			objects.clear();
			fireChange(DefaultController.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(DefaultController.BACKGROUND_IMAGE_NAME, backgroundName);
		fireChange(DefaultController.HORIZONTAL_SCROLL_POSITION, scrollPosition);
		if (objects == null || objects.isEmpty()) {
			fireChange(DefaultController.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
		else {
			fireChange(DefaultController.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}
	
}
