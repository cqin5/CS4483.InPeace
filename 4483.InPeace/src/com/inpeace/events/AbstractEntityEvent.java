package com.inpeace.events;

import com.inpeace.entities.AbstractEntity;

/**
 * This is an extendible class intended for scheduled events that directly effect an enitity's
 * properties.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public abstract class AbstractEntityEvent extends AbstractEvent {
	
	/**   */
	private final AbstractEntity entity;
	
	/**
	 * Constructs a new AbstractEntityEvent object.
	 *
	 * @param entity
	 */
	public AbstractEntityEvent(AbstractEntity entity) {
		this.entity = entity;
	}

	/**
	 * Get the entity
	 *
	 * @return the entity
	 */
	public AbstractEntity getEntity() {
		return entity;
	}

}
