package com.inpeace.engine;

import com.inpeace.controls.ControlManager;
import com.inpeace.states.AbstractState;

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
	private long lastTime, loopTime;
		
	/**   */
	private GraphicsManager graphics;
	
	/**   */
	private AudioManager audio;
	
	/**   */
	private ControlManager controls;
	
	/**   */
	private LogicManager ai;
	
	/**
	 * Constructs a new GameEngine object.
	 *
	 */
	public GameEngine() {
		running = false;
		lastTime = 0;
		loopTime = 0;
		graphics = new GraphicsManager();
		audio = new AudioManager();
		controls = new ControlManager();
		ai = new LogicManager();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		lastTime = System.currentTimeMillis();
		
		Thread graphicsThread = new Thread(graphics);
		graphicsThread.start();

		while (running) {
			loopTime = System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			ai.act(loopTime); //TODO: AI code

			try {
				Thread.sleep(1000 / GameProperties.FPS);
			} catch (Exception e) {
				//NULL BODY
			}
		}
		running = false;
		graphicsThread.interrupt();
		
	}
	
	/**
	 * @return
	 */
	public long getLoopTime() {
		return loopTime;
	}
	
	/**
	 * @param state
	 */
	public void changeState(AbstractState state) {
		graphics.requestStateChange(state.getStateID());
		audio.requestStateChange(state.getStateID());
	}
	
}
