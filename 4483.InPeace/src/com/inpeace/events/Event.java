package com.inpeace.events;

import com.inpeace.actions.AbstractAction;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class Event extends AbstractEvent {
	
	/**   */
	private final AbstractAction[] actions;
	
	/**
	 * Constructs a new Event object.
	 *
	 * @param actions
	 */
	public Event(AbstractAction... actions) {
		this.actions = actions;
	}
	
	/**
	 * Get the actions
	 *
	 * @return the actions
	 */
	public AbstractAction[] getActions() {
		return actions;
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#execute()
	 */
	@Override
	public void execute() {
		
		for (AbstractAction action: actions) {
			action.execute();
		}
	}

}
