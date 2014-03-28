package com.inpeace.engine;

import com.inpeace.controllers.DefaultController;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.models.AudioModel;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.HUDGraphicsModel;
import com.inpeace.models.OverlayGraphicsModel;
import com.inpeace.views.AbstractView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class DataManager {
	
	/**   */
	public static final String VIEW = "View";
	public static final String DEFAULT_GRAPHICS_MODEL = "DefaultGraphicsModel";
	public static final String HUD_GRAPHICS_MODEL = "HUDModel";
	public static final String OVERLAY_GRAPHICS_MODEL = "OverlayModel";
	public static final String AUDIO_MODEL = "AudioModel";
	
	/**   */
	private DefaultController controller;
	
	/**   */
	private DefaultGraphicsModel graphicsModel;
	private HUDGraphicsModel hudModel;
	private OverlayGraphicsModel overlayModel;
	private AudioModel audioModel;
	
	/**
	 * Constructs a new DataManager object.
	 *
	 */
	public DataManager() {
		controller = new DefaultController();
		graphicsModel = null;
		hudModel = null;
		overlayModel = null;
		audioModel = null;
	}

	/**
	 * @param request
	 */
	public void makeRequest(Request request) {
		if (request.type == RequestType.REGISTER) {
			if (request.propertyName == VIEW) {
				controller.registerView((AbstractView) request.value);
			}
			else if (request.propertyName == DEFAULT_GRAPHICS_MODEL) {
				if (graphicsModel != null) {
					controller.deregisterModel(graphicsModel);
				}
				graphicsModel = (DefaultGraphicsModel) request.value;
				controller.registerModel(graphicsModel);
			}
			else if (request.propertyName == HUD_GRAPHICS_MODEL) {
				if (hudModel != null) {
					controller.deregisterModel(hudModel);
				}
				hudModel = (HUDGraphicsModel) request.value;
				controller.registerModel(hudModel);
			}
			else if (request.propertyName == OVERLAY_GRAPHICS_MODEL) {
				if (overlayModel != null) {
					controller.deregisterModel(overlayModel);
				}
				overlayModel = (OverlayGraphicsModel) request.value;
				controller.registerModel(overlayModel);
			}
			else if (request.propertyName == AUDIO_MODEL) {
				if (audioModel != null) {
					controller.deregisterModel(audioModel);
				}
				audioModel = (AudioModel) request.value;
				controller.registerModel(audioModel);
			}
		}
		else {
			controller.processRequest(request);
		}
	}
	
	/**
	 * 
	 */
	public void callRefresh() {
		controller.refresh();
	}
	
}
