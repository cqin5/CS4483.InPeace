package com.inpeace.gui.shell.gamemenu;

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
public class GameMenuDelegate extends BackgroundPanel implements GUIDelegate {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 380393429392427520L;

	/**   */
	private JButton back;
	
	/**   */
	private JButton start;
	
	/**   */
	private JButton collectables;
	
	/**   */
	private JButton settings;
	
	/**
	 * Constructs a new GameMenu object.
	 *
	 * @param relativePath
	 */
	public GameMenuDelegate(String relativePath) {
		super(relativePath);
		// TODO Auto-generated constructor stub
	}
}
