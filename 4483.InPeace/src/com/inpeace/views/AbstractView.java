package com.inpeace.views;

import java.awt.Canvas;
import java.beans.PropertyChangeEvent;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public abstract class AbstractView extends Canvas {
	
	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -247765075058796316L;

	public abstract void update(PropertyChangeEvent e);
	
	public abstract void repaint();
	
}
