package com.inpeace.views;

import java.beans.PropertyChangeEvent;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public interface AbstractView  {

	/**
	 * @param e
	 */
	public void update(PropertyChangeEvent e);
	
	/**
	 * 
	 */
	public void refresh();
	
}
