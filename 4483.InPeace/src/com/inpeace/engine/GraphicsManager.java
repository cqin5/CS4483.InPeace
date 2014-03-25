package com.inpeace.engine;

import java.util.LinkedList;
import java.util.Queue;

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
	private Queue<ChangeRequest> requests;

	/**
	 * Constructs a new GraphicsManager object.
	 *
	 * @param title
	 * @param size
	 */
	public GraphicsManager() {
		controller = new GraphicsController();
		running = false;
		requests = new LinkedList<ChangeRequest>();
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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		
		while (running) {
			
			while (!requests.isEmpty()) {
				controller.processRequest(requests.remove());
			}
			
			controller.refresh();

			try {
				Thread.sleep(1000 / GameProperties.FPS);
			} catch (Exception e) {
				//NULL BODY
			}
		}		
	}
	
	/**
	 * @param request
	 */
	public void makeChangeRequest(ChangeRequest request) {
		requests.add(request);
	}

}
