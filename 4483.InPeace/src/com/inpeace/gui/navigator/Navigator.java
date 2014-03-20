package com.inpeace.gui.navigator;

import java.util.EmptyStackException;
import java.util.Stack;

import com.inpeace.gui.general.GUIDelegate;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class Navigator {

	/**   */
	private GUIDelegate current;

	/**   */
	private Stack<GUIDelegate> history;

	/**
	 * Constructs a new Navigator object.
	 *
	 */
	public Navigator() {
		current = null;
		history = new Stack<GUIDelegate>();
	}
	
	/**
	 * @return
	 */
	public GUIDelegate getCurrentView() {
		return current;
	}

	/**
	 * @return
	 * @throws EmptyStackException
	 */
	public GUIDelegate back() throws EmptyStackException {
		current = history.pop();
		return getCurrentView();
	}

	/**
	 * @param view
	 */
	public void registerView(GUIDelegate view) {
		if (current != null) {
			if (current.isRestorable()) {
				history.push(current);
			}
		}
		current = view;
	}
}
