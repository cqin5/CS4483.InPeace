package com.inpeace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.gui.general.BackgroundPanel;
import com.inpeace.gui.shell.splash.SplashDelegate;
import com.inpeace.gui.window.Window;

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
		//Create game window, centre it, and display it to the screen
		//Window window = new Window();
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//window.setResizable(false);


		
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.pack();
		
		frame.setLayout(new BorderLayout());
		frame.setTitle("Test");
//		frame.setVisible(true);
		
		BackgroundPanel panel = new BackgroundPanel("/com/inpeace/images/backgrounds/test.png",
				(frame.getSize()).width, (frame.getSize()).height, new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);

		frame.setVisible(true);
		
	}
}
