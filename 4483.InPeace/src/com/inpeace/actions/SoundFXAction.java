package com.inpeace.actions;

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
public class SoundFXAction extends AbstractAction {
	
	/**   */
	private String soundName;
	
	/**
	 * Constructs a new SoundFXAction object.
	 *
	 * @param soundName
	 */
	public SoundFXAction(String soundName) {
		this.soundName = soundName;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.actions.AbstractAction#performAction()
	 */
	@Override
	public void performAction() {
		MailRoom.getInstance().postRequest(DefaultController.SOUND_EFFECT, soundName,
				RequestType.CHANGE_PROPERTY);
	}

}
