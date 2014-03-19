package com.inpeace.controls;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingUtilities;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class Mouse {

	public static Point getMouseLocation(Component relativeTo) {
		Point point = new Point(MouseInfo.getPointerInfo().getLocation());
		SwingUtilities.convertPointFromScreen(point, relativeTo);
		return point;
	}
	
}
