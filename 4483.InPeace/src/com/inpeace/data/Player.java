package com.inpeace.data;

import java.io.Serializable;

import com.inpeace.collectibles.Collectibles;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class Player implements Serializable {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 8771165689031839746L;
	
	/**   */
	private String username;
	
	/**   */
	private Settings settings;
	
	/**   */
	private Collectibles collectibles;
	
	/**   */
	private Level currentLevel;

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
	 * Get the collectibles
	 *
	 * @return the collectibles
	 */
	public Collectibles getCollectibles() {
		return collectibles;
	}

	/**
	 * Set the collectibles
	 *
	 * @param collectibles the collectibles to set
	 */
	public void setCollectibles(Collectibles collectibles) {
		this.collectibles = collectibles;
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

}
