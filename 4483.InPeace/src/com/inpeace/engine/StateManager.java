package com.inpeace.engine;

import com.inpeace.exceptions.StateException;
import com.inpeace.states.AbstractState;
import com.inpeace.states.CollectiblesState;
import com.inpeace.states.CreditsState;
import com.inpeace.states.GameMenuState;
import com.inpeace.states.GameState;
import com.inpeace.states.LoadGameState;
import com.inpeace.states.MainMenuState;
import com.inpeace.states.NewGameState;
import com.inpeace.states.PauseMenuState;
import com.inpeace.states.ScrollState;
import com.inpeace.states.SettingsOverlayState;
import com.inpeace.states.SettingsScreenState;
import com.inpeace.states.SplashState;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   25 Mar 2014
 */
public class StateManager {
	
	
	/** State id codes.  */
	public static final int UWO_SPLASH = 1;
	public static final int MAIN_MENU = 2;
	public static final int LOAD_GAME = 3;
	public static final int NEW_GAME = 4;
	public static final int CREDITS = 5;
	public static final int GAME_MENU = 6;
	public static final int SETTINGS_SCREEN = 7;
	public static final int COLLECTIBLES = 8;
	public static final int GAME_PLAY = 9;
	public static final int PAUSE_MENU = 10;
	public static final int SETTINGS_OVERLAY = 11;
	public static final int SCROLL = 12;

	/**   */
	private static StateManager instance = null;
	
	/**   */
	private AbstractState state;
	
	/**   */
	private int currentState;
	
	/**
	 * Constructs a new StateManager object.
	 *
	 */
	private StateManager() {
		currentState = 0;
	}
	
	/**
	 * @return
	 */
	public static StateManager getInstance() {
		if (instance == null) {
			instance = new StateManager();
		}
		return instance;
	}
	
	/**
	 * @param graphics
	 * @param audio
	 * @param logic
	 * @param data
	 * @param stateID
	 * @throws StateException
	 */
	public void loadState(GraphicsManager graphics, AudioManager audio, LogicManager logic,
			DataManager data, int stateID) throws StateException {
		
		if (currentState == stateID) {
			throw new StateException("State change failed, already in state");
		}
		switch (stateID) {
		case UWO_SPLASH:
			state = new SplashState();
			break;
		case MAIN_MENU:
			state = new MainMenuState();
			break;
		case LOAD_GAME:
			state = new LoadGameState();
			break;
		case NEW_GAME:
			state = new NewGameState();
			break;
		case CREDITS:
			state = new CreditsState();
			break;
		case GAME_MENU:
			state = new GameMenuState();
			break;
		case SETTINGS_SCREEN:
			state = new SettingsScreenState();
			break;
		case COLLECTIBLES:
			state = new CollectiblesState();
			break;
		case GAME_PLAY:
			state = new GameState();
			break;
		case PAUSE_MENU:
			state = new PauseMenuState();
			break;
		case SETTINGS_OVERLAY:
			state = new SettingsOverlayState();
			break;
		case SCROLL:
			state = new ScrollState();
			break;
		}
		currentState = stateID;
		
		state.load(graphics, audio, logic, data);
	}
	
}
