package com.inpeace.engine;

import java.util.Stack;

import com.inpeace.exceptions.StateException;
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
	 * @throws StateException
	 */
	public int back() throws StateException {
		if (history.isEmpty()) {
			throw new StateException("State History: unable to go back, no historical views registered");
		}
		current = history.pop();
		return current.getStateID();
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
}
