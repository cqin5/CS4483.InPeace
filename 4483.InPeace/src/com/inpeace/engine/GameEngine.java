package com.inpeace.engine;

import com.inpeace.exceptions.StateException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   23 Mar 2014
 */
public class GameEngine implements Runnable {

	/**   */
	private boolean running;

	/**   */
	private long runTime, startTime;

	/**   */
	private GraphicsManager graphics;
	private AudioManager audio;
	private LogicManager logic;
	private DataManager data;
	private StateManager states;
	private ControlManager controls;

	/**
	 * Constructs a new GameEngine object.
	 *
	 */
	public GameEngine() {
		running = false;
		runTime = 0;
		startTime = 0;
		graphics = new GraphicsManager();
		audio = new AudioManager();
		logic = new LogicManager(this);
		data = new DataManager();
		states = new StateManager();
		controls = new ControlManager(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		startTime = System.currentTimeMillis();


		//TODO:remove following test code
		/*graphics.makeChangeRequest(new Request(GraphicsController.HORIZONTAL_SCROLL_POSITION, 0, Request.CHANGE_PROPERTY_REQUEST));
		graphics.makeChangeRequest(new Request(GraphicsController.BACKGROUND_IMAGE_NAME, "splash", Request.CHANGE_PROPERTY_REQUEST));
		graphics.makeChangeRequest(new Request(GraphicsController.STATE_TYPE, StateManager.OVERLAY_SCREEN, Request.CHANGE_PROPERTY_REQUEST));
		String code = "1-0-0-128-128";
		ImageEntityGraphic entity = new ImageEntityGraphic(1, code, new Point(0,0));

		graphics.makeChangeRequest(new Request(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, code, Request.CHANGE_PROPERTY_REQUEST));
		graphics.makeChangeRequest(new Request(GraphicsController.FOREGROUND_OBJECT_ENTITY, entity, Request.CHANGE_PROPERTY_REQUEST));
*/
		//TODO:remove above test code

		postRequest(new Request(StateManager.LOAD_STATE, StateManager.UWO_SPLASH,
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES));
		
		Thread graphicsThread = new Thread(graphics);
		graphicsThread.start();

		//Thread audioThread = new Thread(audio);
		//audioThread.start();

		while (running) {
			runTime = System.currentTimeMillis() - startTime;

			logic.act(runTime);

			try {
				Thread.sleep(1000 / GameProperties.FPS);
			} catch (Exception e) {
				//NULL BODY
			}
		}
		running = false;
		graphicsThread.interrupt();
		//audioThread.interrupt();

	}

	/**
	 * @return
	 */
	public long getLoopTime() {
		return startTime;
	}
	
	/**
	 * @param request
	 */
	public void postRequest(Request request) {
		switch (request.routingCode) {
		case Request.ROUTE_TO_GRAPHICS:
			graphics.makeChangeRequest(request);
			break;
		case Request.ROUTE_TO_STATES:
			try {
				states.loadState(this, (Integer) request.value);
			} catch (StateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Request.ROUTE_TO_AUDIO:
			audio.makeChangeRequest(request);
			break;
		}
		logic.makeChangeRequest(request);
	}
}
