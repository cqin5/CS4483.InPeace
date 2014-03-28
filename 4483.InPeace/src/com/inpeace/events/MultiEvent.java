package com.inpeace.events;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class MultiEvent extends AbstractEvent {
	
	/**   */
	AbstractEvent[] events;
	
	public MultiEvent(AbstractEvent... events) {
		this.events = events;
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#execute()
	 */
	@Override
	public void execute() {
		
		for (AbstractEvent event: events) {
			event.execute();
		}
	}

}
