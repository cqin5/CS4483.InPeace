package com.inpeace.engine;

import java.util.LinkedList;
import java.util.Queue;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.models.DefaultGraphicsModel;
import com.inpeace.models.HUDGraphicsModel;
import com.inpeace.models.OverlayGraphicsModel;
import com.inpeace.views.DefaultView;

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
	private Queue<Request> requests;

	/**
	 * Constructs a new GraphicsManager object.
	 *
	 * @param title
	 * @param size
	 */
	public GraphicsManager() {
		controller = new GraphicsController();
		running = false;
		requests = new LinkedList<Request>();
		initialiser();
	}
	
	/**
	 * 
	 */
	public void initialiser() {
		controller.addModel(new DefaultGraphicsModel());
		controller.addModel(new HUDGraphicsModel());
		controller.addModel(new OverlayGraphicsModel());
		
		controller.addView(new DefaultView(controller));
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
	public void makeChangeRequest(Request request) {
		requests.add(request);
	}

}
