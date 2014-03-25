package com.inpeace.engine;

import com.inpeace.controls.ControlManager;
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
		
	/**   */
	private AudioManager audio;
	
	/**   */
	private LogicManager logic;
	
	/**   */
	private DataManager data;
	
	/**   */
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
		controls = new ControlManager();
		logic = new LogicManager();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		startTime = System.currentTimeMillis();

		Thread graphicsThread = new Thread(graphics);
		graphicsThread.start();
		
		Thread audioThread = new Thread(audio);
		audioThread.start();

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
		audioThread.interrupt();
		
	}
	
	/**
	 * @return
	 */
	public long getLoopTime() {
		return startTime;
	}
	
	public void changeState(int id) {
		try {
			StateManager.getInstance().loadState(graphics, audio, logic, data, id);
		} catch (StateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
