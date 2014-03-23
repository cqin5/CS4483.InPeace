package com.inpeace.gui.shell.splash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

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
	public SplashDelegate(Dimension dimensions) {
		super(Splash.getGraphicPath(), dimensions, new GridBagLayout());
		setBackground(Color.BLACK);
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
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.BackgroundPanel#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
