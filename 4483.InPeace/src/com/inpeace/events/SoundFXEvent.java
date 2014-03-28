package com.inpeace.events;

import com.inpeace.controllers.DefaultController;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class SoundFXEvent extends AbstractEvent {

	/**   */
	private String soundName;
	
	/**
	 * Constructs a new SoundFXEvent object.
	 *
	 * @param soundName
	 */
	public SoundFXEvent(String soundName) {
		this.soundName = soundName;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.events.AbstractEvent#execute()
	 */
	@Override
	public void execute() {
		MailRoom.getInstance().postRequest(DefaultController.SOUND_EFFECT, soundName, 
				RequestType.CHANGE_PROPERTY);
	}

}
