package com.inpeace;

import java.awt.Dimension;
import java.awt.Graphics2D;

import com.inpeace.gui.AbstractState;
import com.inpeace.gui.GraphicsManager;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   23 Mar 2014
 */
public class GameEngine implements Runnable {

	private boolean running;
	
	private long lastTime, loopTime;
		
	private GraphicsManager graphics;
	
	private AudioManager audio;
	
	public GameEngine() {
		running = false;
		lastTime = 0;
		loopTime = 0;
		graphics = new GraphicsManager("In Peace: A Ghost Story", new Dimension(900,600)); //TODO: eliminate hard coded parameters
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
			
			graphics.repaint();

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
		graphics.setState(state);
		audio.setState(state);
	}

}
