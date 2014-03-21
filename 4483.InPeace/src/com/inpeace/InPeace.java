package com.inpeace;

import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.inpeace.gui.general.BackgroundPanel;
import com.inpeace.gui.shell.splash.Splash;
import com.inpeace.gui.shell.splash.SplashDelegate;
import com.inpeace.gui.window.Window;
import com.inpeace.images.BufferedImageLoader;

/**
 * Main class for the game.
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class InPeace extends JFrame{

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -526923973107606466L;
	private Object getContnetPane;
public InPeace() {
	super();
}
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create game window, centre it, and display it to the screen
		InPeace window = new InPeace();
		window.setSize(600, 600);
		window.getContentPane().removeAll();
		try {
			BufferedImage img = BufferedImageLoader.loadImage(Splash.getGraphicPath());
			Graphics g = img.getGraphics();
			g.drawImage(img, 0 , 0, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setVisible(true);
/*
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//try {
		if (device.isFullScreenSupported()) {
			device.setFullScreenWindow(window);
		} else {
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
			window.setResizable(false);
		}
		window.load(new SplashDelegate());
		
		//} finally {
		//device.setFullScreenWindow(null);
		//}
		 */
	}
}
