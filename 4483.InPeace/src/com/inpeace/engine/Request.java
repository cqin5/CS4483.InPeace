package com.inpeace.engine;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public class Request {
	
	/**   */
	public static final int CLEAR_PROPERTY_REQUEST = 0;
	public static final int CHANGE_PROPERTY_REQUEST = 1;

	/**   */
	public final int requestType;
	
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
	public Request(String propertyName, Object value, int requestType) {
		this.propertyName = propertyName;
		this.value = value;
		this.requestType = requestType;
	}
}
