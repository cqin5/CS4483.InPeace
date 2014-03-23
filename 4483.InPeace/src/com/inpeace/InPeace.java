package com.inpeace;

import java.awt.Dimension;

import com.inpeace.gui.Controller;
import com.inpeace.gui.shell.splash.SplashDelegate;

/**
 * Main class for the game.
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class InPeace {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create game window, and display it to the screen
		Controller window = new Controller("In Peace: A Ghost Story", new Dimension(900,600));
		window.load(new SplashDelegate(window));
		
		window.setVisible(true);
		
	}
}
