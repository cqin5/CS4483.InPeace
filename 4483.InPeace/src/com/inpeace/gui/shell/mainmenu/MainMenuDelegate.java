package com.inpeace.gui.shell.mainmenu;

import javax.swing.JButton;

import com.inpeace.gui.general.BackgroundPanel;
import com.inpeace.gui.general.GUIDelegate;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class MainMenuDelegate extends BackgroundPanel implements GUIDelegate {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 6545247443097818762L;

	/**   */
	private JButton loadGame;
	
	/**   */
	private JButton newGame;
	
	/**   */
	private JButton credits;
	
	/**
	 * Constructs a new MainMenu object.
	 *
	 * @param relativePath
	 */
	public MainMenuDelegate(String relativePath) {
		super(relativePath);
		// TODO Auto-generated constructor stub
	}
}
