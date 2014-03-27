package com.inpeace.events;



/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public abstract class AbstractEvent {

	/**   */
	private Long time;
	
	/**   */
	private Integer eventID;
	
	/**
	 * Constructs a new Event object.
	 *
	 * @param time
	 * @param eventID
	 */
	public AbstractEvent() {
		setTime(0L);
		setEventID(0);
	}

	/**
	 * Get the time
	 *
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * Set the time
	 *
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	/**
	 * Get the eventID
	 *
	 * @return the eventID
	 */
	public Integer getEventID() {
		return eventID;
	}

	/**
	 * Set the eventID
	 *
	 * @param eventID the eventID to set
	 */
	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}

	/**
	 * @param event
	 * @return
	 */
	public boolean equals(AbstractEvent event) {
		if (eventID.equals(event.getEventID()) && time.equals(event.getTime())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public abstract void execute();
	
}
