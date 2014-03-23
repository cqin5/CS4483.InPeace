package com.inpeace.gui.shell.splash;

import java.awt.Color;
import java.awt.GridBagLayout;

import com.inpeace.gui.Controller;
import com.inpeace.gui.general.BackgroundPanel;
import com.inpeace.gui.general.GUIDelegate;
import com.inpeace.gui.shell.mainmenu.MainMenuDelegate;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class SplashDelegate extends BackgroundPanel implements GUIDelegate {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 7655251010645403383L;
	
	/** Seconds to display the splash  */
	private static final int duration = 1;
	
	/**   */
	private static final String graphicPath = "backgrounds/test1.png";
	
	/**   */
	private static Controller controller;

	/**
	 * Constructs a new SplashDelegate object.
	 *
	 * @param relativePath
	 */
	public SplashDelegate(Controller controller) {
		super(graphicPath, controller.getSize(), new GridBagLayout());
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#close()
	 */
	@Override
	public void close() {
		//NULL BODY
		//No action to be performed
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		MainMenuDelegate main = new MainMenuDelegate(controller);
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			//NULL BODY
		}
		controller.load(main);
	}

}
