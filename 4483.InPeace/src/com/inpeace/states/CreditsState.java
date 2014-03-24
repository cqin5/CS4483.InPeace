package com.inpeace.states;

import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class CreditsState extends AbstractState {

	/**
	 * Get the backgroundPath
	 *
	 * @return the backgroundPath
	 */
	public String getBackgroundPath() {
		return backgroundPath;
	}

	/**
	 * Set the backgroundPath
	 *
	 * @param backgroundPath the backgroundPath to set
	 */
	public void setBackgroundPath(String backgroundPath) {
		this.backgroundPath = backgroundPath;
	}

	/**
	 * Get the speed
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Set the speed
	 *
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Get the credits
	 *
	 * @return the credits
	 */
	public ArrayList<String> getCredits() {
		return credits;
	}

	/**
	 * Set the credits
	 *
	 * @param credits the credits to set
	 */
	public void setCredits(ArrayList<String> credits) {
		this.credits = credits;
	}

	/**   */
	private String backgroundPath;
	
	/**   */
	private int speed;
	
	/**   */
	private ArrayList<String> credits;

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
