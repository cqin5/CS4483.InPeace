package com.inpeace;

import com.inpeace.engine.StateManager.StateID;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public class GameProperties {

	/**   */
	public static final int FPS = 60;
	
	public static final String TITLE = "In Peace: A Ghost Story (Demo)";
	
	public static final StateID LAUNCH_STATE = StateID.UWO_SPLASH;
	
	public static final int DEFAULT_WIDTH = 1440; //TODO: update with proper width
	
	public static final int DEFAULT_HEIGHT = (int) (DEFAULT_WIDTH / 1.78);
	
	public static final int DEFAULT_VERTICAL_ALIGNMENT = 0;
	
}
