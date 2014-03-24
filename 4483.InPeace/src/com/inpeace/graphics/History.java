package com.inpeace.graphics;

import java.util.EmptyStackException;
import java.util.Stack;

import com.inpeace.states.AbstractState;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class History {

	/**   */
	private AbstractState current;

	/**   */
	private Stack<AbstractState> history;

	/**
	 * Constructs a new Navigator object.
	 *
	 */
	public History() {
		current = null;
		history = new Stack<AbstractState>();
	}
	
	/**
	 * @return
	 */
	public AbstractState getCurrentScreen() {
		return current;
	}

	/**
	 * @return
	 * @throws EmptyStackException
	 */
	public AbstractState back() throws EmptyStackException {
		current = history.pop();
		return getCurrentScreen();
	}

	/**
	 * @param screen
	 */
	public void registerView(AbstractState screen) {
		if (current != null) {
			if (current.isHistorical()) {
				history.push(current);
			}
		}
		current = screen;
	}
	
	/**
	 * @return
	 */
	public int size() {
		return history.size();
	}
}
