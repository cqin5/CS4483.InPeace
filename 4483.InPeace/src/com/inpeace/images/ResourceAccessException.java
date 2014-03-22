package com.inpeace.images;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class ResourceAccessException extends Exception {

	/**   */
	private static final long serialVersionUID = -2602552730358583984L;
	
	/**
	 * Constructs a new ImageLoadException object.
	 *
	 * @param message
	 */
	public ResourceAccessException(String message) {
		super(message);
	}
}
