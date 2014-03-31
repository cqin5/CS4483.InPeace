package com.inpeace.models;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   31 Mar 2014
 */
public class PlayerModel {

	/**   */
	private String username = null;
	
	/**   */
	private int currentLevel = 1;
	
	/**   */
	private boolean[] collectibles = {false};

	/**
	 * Get the username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the currentLevel
	 *
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Set the currentLevel
	 *
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Get the collectibles
	 *
	 * @return the collectibles
	 */
	public boolean[] getCollectibles() {
		return collectibles;
	}

	/**
	 * Set the collectibles
	 *
	 * @param collectibles the collectibles to set
	 */
	public void setCollectibles(boolean[] collectibles) {
		this.collectibles = collectibles;
	}
	
	public void setCollected(int index) {
		if (index < collectibles.length && index >= 0) {
			collectibles[index] = true;
		}
	}
	
}
