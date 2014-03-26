package com.inpeace.engine;

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
	public AbstractState getCurrentState() {
		return current;
	}

	/**
	 * @return
	 * @throws EmptyStackException
	 */
	public AbstractState back() throws EmptyStackException {
		current = history.pop();
		return getCurrentState();
	}

	/**
	 * @param screen
	 */
	public void registerState(AbstractState state) {
		if (current != null) {
			if (current.isHistorical()) {
				history.push(current);
			}
		}
		current = state;
	}
	
	/**
	 * @return
	 */
	public int size() {
		return history.size();
	}
}
