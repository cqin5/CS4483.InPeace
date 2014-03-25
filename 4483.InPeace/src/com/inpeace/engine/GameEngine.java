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
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		lastTime = System.currentTimeMillis();

		while (running) {
			loopTime = System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			//TODO: type AI code

			try { Thread.sleep(10); } catch (Exception e) {}
		}
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
	public void setState(AbstractState state) {
		graphics.loadState(state);
		audio.loadState(state);
	}
	
}
