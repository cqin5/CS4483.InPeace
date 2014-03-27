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
	public static final int CLEAR_PROPERTY_REQUEST = 0;
	public static final int CHANGE_PROPERTY_REQUEST = 1;
	public static final int REGISTRATION_REQUEST = 2;
	public static final int DEREGISTRATION_REQUEST = 3;
	
	/** Routing codes.  */
	public static final int ROUTE_TO_GRAPHICS = 0;
	public static final int ROUTE_TO_STATES = 1;
	public static final int ROUTE_TO_AUDIO = 2;
	public static final int ROUTE_TO_DATA = 4;

	/**   */
	public final int type;
	
	/**   */
	public final int[] routingCodes;
	
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
	public Request(String propertyName, Object value, int requestType, int... routingCodes) {
		this.propertyName = propertyName;
		this.value = value;
		this.type = requestType;
		this.routingCodes = routingCodes;
	}
}
