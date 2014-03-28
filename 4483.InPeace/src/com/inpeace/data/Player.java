package com.inpeace.data;

import java.io.Serializable;

import com.inpeace.levels.Level;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class Player implements Serializable {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 8771165689031839746L;
	
	/**   */
	private String username = null;
	
	/**   */
	private Settings settings = null;
	
	/**   */
	private Level currentLevel = null;
	
	/**   */
	private boolean[] collectibles = null;

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
	 * Get the settings
	 *
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * Set the settings
	 *
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	/**
	 * Get the currentLevel
	 *
	 * @return the currentLevel
	 */
	public Level getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Set the currentLevel
	 *
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(Level currentLevel) {
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
