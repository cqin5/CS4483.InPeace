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
		logic = new LogicManager();
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

		postRequest(StateManager.LOAD_STATE, GameProperties.LAUNCH_STATE,
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES);
		
		Thread graphicsThread = new Thread(graphics);
		graphicsThread.start();

		//Thread audioThread = new Thread(audio);
		//audioThread.start();

		while (running) {
			runTime = System.currentTimeMillis() - startTime;

			logic.executeMaturedEvents(this);

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
	public long getRunTime() {
		return runTime;
	}
	
	/**
	 * @param request
	 */
	public void postRequest(String propertyName, Object value, int type, int routingCode) {
		Request request = new Request(propertyName, value, type, routingCode);
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
