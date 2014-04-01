package com.inpeace.characterfilter;

import java.io.Serializable;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public abstract class AbstractCharacterFilter implements Serializable {
	
	/**   */
	private static final long serialVersionUID = -3423690587521955998L;

	/**
	 * @param e
	 * @return
	 */
	public abstract boolean filter(char c);

}
