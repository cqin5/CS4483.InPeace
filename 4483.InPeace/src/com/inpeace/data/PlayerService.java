package com.inpeace.data;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class PlayerService {

	private static PlayerService instance = null;
	
	/**   */
	private Player player;

	private PlayerService() {
		//NULL BODY
	}
	
	public static PlayerService getInstance() {
		if (instance == null) {
			instance = new PlayerService();
		}
		return instance;
	}
	
}
