package com.inpeace;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Main class for the game.
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class InPeace extends JFrame {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -526923973107606466L;

	/**
	 * Constructs a new InPeace object.
	 *
	 */
	public InPeace() {
		setTitle("In Peace: A Ghost Story");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create game window, centre it, and display it to the screen
				InPeace inpeace = new InPeace();
				
				GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
				//try {
				  if (device.isFullScreenSupported()) {
				    device.setFullScreenWindow(inpeace);
					inpeace.add(new JLabel("TEST"));

				  } else {
					  inpeace.setExtendedState(JFrame.MAXIMIZED_BOTH);
				  }
				//} finally {
				  //device.setFullScreenWindow(null);
				//}
	}
}
