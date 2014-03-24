package com.inpeace.data;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class LevelService {

	private static LevelService instance = null;
	
	/**   */
	private Level level;

	private LevelService() {
		//NULL BODY
	}
	
	public static LevelService getInstance() {
		if (instance == null) {
			instance = new LevelService();
		}
		return instance;
	}
}
