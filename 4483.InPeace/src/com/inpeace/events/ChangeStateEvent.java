package com.inpeace.events;

import com.inpeace.engine.Schedule;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   26 Mar 2014
 */
public class ChangeStateEvent extends AbstractEvent {
	
	private final int newStateCode;

	/**
	 * Constructs a new ChangeStateEvent object.
	 *
	 * @param time
	 */
	public ChangeStateEvent(Long time, int newStateCode) {
		super(time);
		this.newStateCode = newStateCode;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#perform(com.inpeace.engine.Schedule)
	 */
	@Override
	public void perform(Schedule scheduler) {
		// TODO Auto-generated method stub
		
	}

}
