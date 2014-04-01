package com.inpeace.engine;

import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.exceptions.StateException;
import com.inpeace.input.Keyboard;
import com.inpeace.states.AbstractState;
import com.inpeace.states.AbstractState.StateType;
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
	public static enum StateID {
		UWO_SPLASH, MAIN_MENU, LOAD_GAME, NEW_GAME, 
		CREDITS, GAME_MENU, SETTINGS_SCREEN, COLLECTIBLES, GAME_PLAY, PAUSE_MENU,
		SETTINGS_OVERLAY, SCROLL
	}

	/**   */
	private static StateManager instance = null;

	/**   */
	private History history;

	/**   */
	private StateID currentStateID;

	/**
	 * Constructs a new StateManager object.
	 *
	 */
	private StateManager() {
		history = new History();
		currentStateID = null;
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
	 * @param stateID
	 * @throws StateException
	 */
	public void changeState(StateID stateID) throws StateException {

		AbstractState oldState = history.getCurrentState();
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
		default:
			break;
		}
		loadState(oldState, stateID);
	}

	/**
	 * @param oldState
	 * @param stateID
	 */
	private void loadState(AbstractState oldState, StateID stateID) {
		currentStateID = stateID;

		if (oldState == null) {
			history.getCurrentState().load();
		}
		else {
			oldState.setHotKeys(Keyboard.getInstance().getHotKeys());
			Keyboard.getInstance().clearFocus();

			if (history.getCurrentState().getType() == StateType.OVERLAY) {
				if (oldState.getType() == StateType.OVERLAY) {
					oldState.close();
				}
			}
			else {
				oldState.close();
			}
			history.getCurrentState().load();

			MailRoom.getInstance().postRequest(PropertyName.STATE_TYPE, history.getCurrentState().getType(), 
					RequestType.CHANGE_PROPERTY);
		}
	}

	/**
	 * @throws StateException 
	 * 
	 */
	public void back() throws StateException {
		AbstractState oldState = history.getCurrentState();
		StateID stateID = history.back();
		Keyboard.getInstance().setHotKeys(history.getCurrentState().getHotKeys());
		loadState(oldState, stateID);
	}

	/**
	 * 
	 */
	public void quit() {
		history.closeAll();
		System.exit(0);
	}

}
