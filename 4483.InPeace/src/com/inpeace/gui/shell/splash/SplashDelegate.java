package com.inpeace.gui.shell.splash;

import javax.swing.JLabel;

import com.inpeace.gui.general.BackgroundPanel;
import com.inpeace.gui.general.GUIDelegate;

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

	/**
	 * Constructs a new SplashDelegate object.
	 *
	 * @param relativePath
	 */
	public SplashDelegate() {
		super(Splash.getGraphicPath());
		add(new JLabel("Test"));
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		return false;
	}

}
