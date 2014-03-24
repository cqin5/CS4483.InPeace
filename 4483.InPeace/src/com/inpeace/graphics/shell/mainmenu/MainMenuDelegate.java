package com.inpeace.gui.shell.mainmenu;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import com.inpeace.gui.AbstractView;
import com.inpeace.gui.GraphicsManager;
import com.inpeace.gui.general.BackgroundPanel;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class MainMenuDelegate extends BackgroundPanel implements AbstractView {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 6545247443097818762L;
	
	/**   */
	private static final String backgroundPath = "backgrounds/test.jpg";
	
	/**   */
	private static final String buttonImages = "buttons/mainmenu.png";
	
	/**   */
	private static GraphicsManager window;

	/**   */
	private JButton loadGame;
	
	/**   */
	private JButton newGame;
	
	/**   */
	private JButton credits;
	
	/**
	 * Constructs a new MainMenuDelegate object.
	 *
	 * @param relativePath
	 * @param dimensions
	 * @param layout
	 */
	public MainMenuDelegate(GraphicsManager window) {
		super(backgroundPath, window.getSize(), new GridBagLayout());
	}
	
	private void initialise() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		initialise();
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}
