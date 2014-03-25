package com.inpeace.engine;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public class ChangeRequest {

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
	public ChangeRequest(String propertyName, Object value) {
		this.propertyName = propertyName;
		this.value = value;
	}
}
