package com.inpeace.engine;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.models.BackgroundModel;
import com.inpeace.models.ForegroundModel;
import com.inpeace.models.HUDModel;
import com.inpeace.models.OverlayModel;
import com.inpeace.states.AbstractState;
import com.inpeace.views.MainView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class GraphicsManager {

	/**   */
	private GraphicsController controller;

	/**
	 * Constructs a new GraphicsManager object.
	 *
	 * @param title
	 * @param size
	 */
	public GraphicsManager() {
		controller = new GraphicsController();
		initialiser();
	}
	
	/**
	 * 
	 */
	public void initialiser() {
		controller.addModel(new BackgroundModel());
		controller.addModel(new ForegroundModel());
		controller.addModel(new HUDModel());
		controller.addModel(new OverlayModel());
		
		controller.addView(new MainView(controller));
	}

	/**
	 * 
	 * @param state
	 */
	public void loadState(AbstractState state) {
		controller.loadState(state);
	}

}
