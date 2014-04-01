package com.inpeace.engine;

import com.inpeace.controllers.PropertyName;

/**
 * The class responsible for carrying requests to the various parts of the game engine.  Think of
 * this object like an office memo.
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public class Request {
	
	/** Request type codes.  */
	public static enum RequestType {
		CHANGE_PROPERTY, REGISTER, DEREGISTER
	}

	/**   */
	public final RequestType type;
	
	/**   */
	public final PropertyName propertyName;
	
	/**   */
	public final Object value;
	
	/**
	 * Constructs a new ChangeRequest object.
	 *
	 * @param propertyName
	 * @param value
	 */
	public Request(PropertyName propertyName, Object value, RequestType type) {
		this.propertyName = propertyName;
		this.value = value;
		this.type = type;
	}
	
}
