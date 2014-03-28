package com.inpeace.engine;

import com.inpeace.data.Player;
import com.inpeace.levels.Level;
import com.inpeace.levels.LevelFactory;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   28 Mar 2014
 */
public class PersistentDataHandler {

	/**   */
	private static PersistentDataHandler instance;
	
	/**   */
	private Player player;
	
	/**
	 * Constructs a new PersistentDataHandler object.
	 *
	 */
	private PersistentDataHandler() {
		player = null;
	}
	
	public static PersistentDataHandler getInstance() {
		if (instance == null) {
			instance = new PersistentDataHandler();
		}
		return instance;
	}
	
	/**
	 * @param LevelNum
	 * @return
	 */
	public Level buildLevel(int levelNum) {
		Level level = LevelFactory.buildLevel(levelNum);
		player.setCurrentLevel(level);
		return level;
	}
	
	/**
	 * @param collectibleIndex
	 */
	public void foundCollectible(int collectibleIndex) {
		player.setCollected(collectibleIndex);
	}
}
