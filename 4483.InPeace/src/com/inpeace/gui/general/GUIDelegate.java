package com.inpeace.gui.general;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public interface GUIDelegate {

	/**
	 * @return
	 */
	public boolean isHistorical();
	
	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public void close();
	
}
