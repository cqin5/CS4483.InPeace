	package com.inpeace.actions;

import com.inpeace.controllers.PropertyName;
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
	private static final long serialVersionUID = 3504108628097649308L;
	
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
	public void execute() {
		MailRoom.getInstance().postRequest(PropertyName.SOUND_EFFECT, soundName,
				RequestType.CHANGE_PROPERTY);
	}

}
