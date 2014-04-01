package com.inpeace.actions;

import com.inpeace.entities.AbstractEntity;

/**
 * This is an extendible class intended for actions that directly effect the properties of the
 * entity to which they are attached.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public abstract class AbstractEntityAction extends AbstractAction {
	
	/**   */
	private static final long serialVersionUID = -6176374354197819032L;
	
	/**   */
	private final AbstractEntity entity;
	
	/**
	 * Constructs a new AbstractEntityAction object.
	 *
	 * @param entity
	 */
	public AbstractEntityAction(AbstractEntity entity) {
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
