package com.inpeace.gui.shell.credits;

import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class Credits {
	
	/**   */
	private String backgroundPath;
	
	/**   */
	private int speed;
	
	/**   */
	private ArrayList<String> credits;

	/**
	 * Constructs a new Credits object.
	 *
	 * @param speed
	 * @param credits
	 */
	public Credits(int speed, ArrayList<String> credits) {
		this.speed = speed;
		this.credits = credits;
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
	 * Get the credits
	 *
	 * @return the credits
	 */
	public ArrayList<String> getCredits() {
		return credits;
	}
	
}
