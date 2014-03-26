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

		changeState(StateManager.UWO_SPLASH);
		
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

	public void changeState(int id) {
		try {
			states.loadState(graphics, audio, logic, data, id);
		} catch (StateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param request
	 */
	public void postGraphicsRequest(Request request) {
		graphics.makeChangeRequest(request);
	}
	
	/**
	 * @param request
	 */
	public void postAudioRequest(Request request) {
		audio.makeChangeRequest(request);
	}

	/**
	 * @param request
	 */
	public void postLocicRequest(Request request) {
		logic.makeChangeRequest(request);
	}
}
