package com.inpeace.gui;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class GUI {
	
	Stack<GUIDelegate> views;
	
	/**
	 * @return
	 * @throws EmptyStackException
	 */
	public GUIDelegate getPreviousView() throws EmptyStackException {
		return views.pop();
	}
	
	public void registerView(GUIDelegate view) {
		if (view.isRestorable) {
			views.push(view);
		}
	}
}
