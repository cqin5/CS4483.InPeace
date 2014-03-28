package com.inpeace.engine;

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
		CLEAR_PROPERTY, CHANGE_PROPERTY, REGISTER, DEREGISTER, SAVE, LOAD
	}
	
	/** Routing codes.  */
	public static enum RouteTo {
		STATES, DATA
	}

	/**   */
	public final RequestType type;
	
	/**   */
	public final RouteTo routingCode;
	
	/**   */
	public final String propertyName;
	
	/**   */
	public final Object value;
	
	/**
	 * Constructs a new ChangeRequest object.
	 *
	 * @param propertyName
	 * @param value
	 */
	public Request(String propertyName, Object value, RequestType type, RouteTo routingCode) {
		this.propertyName = propertyName;
		this.value = value;
		this.type = type;
		this.routingCode = routingCode;
	}
	
}
