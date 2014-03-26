package com.inpeace.engine;

/**
 * 
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
	public static final int ROUTE_TO_LOGIC = 3;
	public static final int ROUTE_TO_DATA = 4;

	/**   */
	public final int requestType;
	
	/**   */
	public final int routingCode;
	
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
	public Request(String propertyName, Object value, int requestType, int routingCode) {
		this.propertyName = propertyName;
		this.value = value;
		this.requestType = requestType;
		this.routingCode = routingCode;
	}
}
