package com.inpeace.engine;

import com.inpeace.controllers.DefaultController;
import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.exceptions.StateException;
import com.inpeace.views.DefaultView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class GameEngine implements Runnable {

	/**   */
	private boolean running;

	/**   */
	private long loopTime;

	/**   */
	private DefaultController controller;

	/**
	 * Constructs a new GameEngine object.
	 *
	 */
	public GameEngine() {
		running = false;
		loopTime = 0;
		controller = new DefaultController();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;

		MailRoom.getInstance().postRequest(PropertyName.VIEW, new DefaultView(),
				RequestType.REGISTER);
		controller.processRequests();
		
		try {
			StateManager.getInstance().changeState(GameProperties.LAUNCH_STATE);
		} catch (StateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (running) {
			loopTime = System.currentTimeMillis() - loopTime;

			Scheduler.getInstance().executeMaturedEvents();
			controller.processRequests();
			controller.refresh();

			try {
				Thread.sleep((1000 / GameProperties.FPS) - loopTime);
			} catch (Exception e) {
				//NULL BODY
			}
		}
		running = false;

	}

}
