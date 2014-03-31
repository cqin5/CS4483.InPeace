package com.inpeace.controllers;

import com.inpeace.engine.DataManager;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request;
import com.inpeace.exceptions.MVCException;
import com.inpeace.models.AbstractModel;
import com.inpeace.models.AudioModel;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.HUDGraphicsModel;
import com.inpeace.models.OverlayGraphicsModel;
import com.inpeace.models.SettingsModel;
import com.inpeace.views.AbstractView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class DefaultController extends AbstractController {	

	/**
	 * @param request
	 */
	public void processRequests() {
		Request request = null;
		while ((request = MailRoom.getInstance().getRequest()) != null) {
			try {
				switch (request.type) {
				case CHANGE_PROPERTY:
					setProperty(request.propertyName.toString(), request.value);
					break;
				case DEREGISTER:
					if (request.propertyName.equals(MODEL)) {
						deregisterModel((AbstractModel) request.value);
					}
					else if (request.propertyName.equals(VIEW)) {
						deregisterView((AbstractView) request.value);
					}
					break;
				case REGISTER:
					processRegistration(request);
					break;
				default:
					break;
				}
			} catch (MVCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param request
	 */
	public void processRegistration(Request request) {
		try {
			DataManager instance = DataManager.getInstance();
			if (request.propertyName == PropertyName.VIEW) {
				registerView((AbstractView) request.value);
			}
			else if (request.propertyName == PropertyName.DEFAULT_GRAPHICS_MODEL) {
				if (instance.getDefaultGraphicsModel() != null) {
					deregisterModel(instance.getDefaultGraphicsModel());
				}
				instance.setDefaultGraphicsModel((DefaultGraphicsModel) request.value);
				registerModel(instance.getDefaultGraphicsModel());
			}
			else if (request.propertyName == PropertyName.HUD_GRAPHICS_MODEL) {
				if (instance.getHudGraphicsModel() != null) {
					deregisterModel(instance.getHudGraphicsModel());
				}
				instance.setHudGraphicsModel((HUDGraphicsModel) request.value);
				registerModel(instance.getHudGraphicsModel());
			}
			else if (request.propertyName == PropertyName.OVERLAY_GRAPHICS_MODEL) {
				if (instance.getOverlayGraphicsModel() != null) {
					deregisterModel(instance.getOverlayGraphicsModel());
				}
				instance.setOverlayGraphicsModel((OverlayGraphicsModel) request.value);
				registerModel(instance.getOverlayGraphicsModel());
			}
			else if (request.propertyName == PropertyName.AUDIO_MODEL) {
				if (instance.getAudioModel() != null) {
					deregisterModel(instance.getAudioModel());
				}
				instance.setAudioModel((AudioModel) request.value);
				registerModel(instance.getAudioModel());
			}
			else if (request.propertyName == PropertyName.AUDIO_MODEL) {
				if (instance.getSettingsModel() != null) {
					deregisterModel(instance.getSettingsModel());
				}
				instance.setSettingsModel((SettingsModel) request.value);
				registerModel(instance.getSettingsModel());
			}
		} catch (MVCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
