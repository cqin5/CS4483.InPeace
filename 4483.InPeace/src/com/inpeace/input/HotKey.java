package com.inpeace.input;

import com.inpeace.entities.AbstractEntity;
import com.inpeace.exceptions.InputException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class HotKey {

	/**   */
	private final char key;

	/**   */
	private final AbstractEntity entity;

	/**
	 * Constructs a new HotKey object.
	 *
	 * @param key
	 * @param entity
	 * @throws InputException
	 */
	public HotKey(char key, AbstractEntity entity) throws InputException {
		this.key = key;
		if (entity != null) {
			this.entity = entity;
		}
		else {
			throw new InputException("HotKey cannot have a null entity member. (HotKey");
		}
	}

	/**
	 * Get the key
	 *
	 * @return the key
	 */
	public char getKey() {
		return key;
	}

	/**
	 * Get the entity
	 *
	 * @return the entity
	 */
	public AbstractEntity getEntity() {
		return entity;
	}

	public void pressed() {
		entity.press();
	}

}
