package com.inpeace.models;

import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.PropertyName;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.entities.NullEntity;
import com.inpeace.states.AbstractState.StateType;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class DefaultGraphicsModel extends AbstractModel {
	
	/**   */
	private static final long serialVersionUID = -1437814667145135579L;

	/** Type of state  */
	private StateType stateType;
	
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
		super();
		backgroundName = "";
		scrollPosition = 0;
		stateType = StateType.NONE;
		objects = new TreeMap<Integer, AbstractEntity>();
	}
	
	/**
	 * Set the state type
	 * 
	 * @param stateType	the state type to set
	 */
	public void setStateType(StateType stateType) {
		if (this.stateType != stateType) {
			this.stateType = stateType;
			fireChange(PropertyName.STATE_TYPE, stateType);
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
			fireChange(PropertyName.BACKGROUND_IMAGE_NAME, backgroundName);
		}
	}

	/**
	 * Set the scrollPosition
	 *
	 * @param scrollPosition the scrollPosition to set
	 */
	public void setHorizontalScrollPosition(Integer scrollPosition) {
		if (this.scrollPosition != scrollPosition) {
			this.scrollPosition = scrollPosition;
			fireChange(PropertyName.HORIZONTAL_SCROLL_POSITION, scrollPosition);
		}
	}

	/**
	 * @param entity
	 */
	public void setForegroundObjectEntity(AbstractEntity entity) {
		if (entity.getClass().equals(NullEntity.class)) {
			objects.remove(entity.getDepth());
		}
		else {
			objects.put(entity.getDepth(), entity);
			fireChange(PropertyName.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(PropertyName.BACKGROUND_IMAGE_NAME, backgroundName);
		fireChange(PropertyName.HORIZONTAL_SCROLL_POSITION, scrollPosition);
		if (objects == null || objects.isEmpty()) {
			fireChange(PropertyName.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
		else {
			fireChange(PropertyName.FOREGROUND_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}
	
}
