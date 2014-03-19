package GUI;

import javax.swing.JFrame;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("In Peace: A Ghost Story");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create game window, centre it, and display it to the screen
				InPeace game = new InPeace();
				game.setLocationRelativeTo(null);
				game.setVisible(true);
	}
}
