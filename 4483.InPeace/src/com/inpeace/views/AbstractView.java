package com.inpeace.views;

import java.awt.Point;
import java.beans.PropertyChangeEvent;

import com.inpeace.entities.AbstractEntity;

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
	
	/**
	 * @param p
	 * @return
	 */
	public AbstractEntity getEntityAt(Point p);
	
	/**
	 * @param x
	 * @param y
	 */
	public void scroll(int x, int y);
	
	/**
	 * @param p
	 */
	public void setMousePosition(Point p);
	
}
