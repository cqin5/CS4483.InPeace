package com.inpeace.engine;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.models.BackgroundModel;
import com.inpeace.models.ForegroundModel;
import com.inpeace.models.HUDModel;
import com.inpeace.models.OverlayModel;
import com.inpeace.views.MainView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class GraphicsManager implements Runnable {
	
	/**   */
	private GraphicsController controller;
	
	/**   */
	private boolean running;
	
	/**   */
	private int stateID;

	/**
	 * Constructs a new GraphicsManager object.
	 *
	 * @param title
	 * @param size
	 */
	public GraphicsManager() {
		controller = new GraphicsController();
		running = false;
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
	 * @param newStateID
	 */
	public void requestStateChange(int newStateID) {
		stateID = newStateID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		
		int loopStateID = stateID;
		
		while (running) {
			
			if (loopStateID != stateID) {
				controller.loadState(StateManager.getInstance().getCurrentState());
				loopStateID = stateID;
			}
			
			controller.refresh();

			try {
				Thread.sleep(1000 / GameProperties.FPS);
			} catch (Exception e) {
				//NULL BODY
			}
		}
		
	}

}
