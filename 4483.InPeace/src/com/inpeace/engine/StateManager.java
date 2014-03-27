package com.inpeace.engine;

import com.inpeace.exceptions.StateException;
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
 * @version 1.0
 * @since   25 Mar 2014
 */
public class StateManager {

	/** State id codes.  */
	public static final int PREVIOUS_HISTORICAL_STATE = -1;
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

	public static final String LOAD_STATE = "loadState";

	/**   */
	private History history;

	/**   */
	private int currentStateID;

	/**
	 * Constructs a new StateManager object.
	 *
	 */
	public StateManager() {
		history = new History();
		currentStateID = 0;
	}

	/**
	 * @param graphics
	 * @param audio
	 * @param logic
	 * @param data
	 * @param stateID
	 * @throws StateException
	 */
	public void loadState(int stateID) throws StateException {

		if (stateID == PREVIOUS_HISTORICAL_STATE) {
			stateID = history.back();
			if (currentStateID == stateID) {
				throw new StateException("State change failed, already in state");
			}
		}
		else {
			if (currentStateID == stateID) {
				throw new StateException("State change failed, already in state");
			}
			switch (stateID) {
			case UWO_SPLASH:
				history.registerState(new SplashState());
				break;
			case MAIN_MENU:
				history.registerState(new MainMenuState());
				break;
			case LOAD_GAME:
				history.registerState(new LoadGameState());
				break;
			case NEW_GAME:
				history.registerState(new NewGameState());
				break;
			case CREDITS:
				history.registerState(new CreditsState());
				break;
			case GAME_MENU:
				history.registerState(new GameMenuState());
				break;
			case SETTINGS_SCREEN:
				history.registerState(new SettingsScreenState());
				break;
			case COLLECTIBLES:
				history.registerState(new CollectiblesState());
				break;
			case GAME_PLAY:
				history.registerState(new GameState());
				break;
			case PAUSE_MENU:
				history.registerState(new PauseMenuState());
				break;
			case SETTINGS_OVERLAY:
				history.registerState(new SettingsOverlayState());
				break;
			case SCROLL:
				history.registerState(new ScrollState());
				break;
			}
		}
		currentStateID = stateID;

		history.getCurrentState().load();
	}

}
