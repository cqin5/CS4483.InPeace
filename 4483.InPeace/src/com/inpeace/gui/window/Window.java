package com.inpeace.gui.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.gui.general.GUIDelegate;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class Window extends JFrame {

	/**   */
	private static final long serialVersionUID = -769022227591869099L;
	
	/**   */
	private History history;
		
	/**
	 * Constructs a new NavigatorService object.
	 *
	 */
	public Window() {
		super();
		history = new History();
		
		setTitle("In Peace: A Ghost Story");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter()
        {
            /* (non-Javadoc)
             * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
             */
            @Override
            public void windowClosing(WindowEvent e)
            {
                try {
					quit();
				} catch (Exception e1) {
					//TODO: display there was an error quitting message
				}
                e.getWindow().dispose();
            }
        });
		
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (!device.isFullScreenSupported()) {
			device.setFullScreenWindow(this);
		} else {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setResizable(false);
		}
		
	}
	
	/**
	 * @param view
	 * @param window
	 */
	public void load(GUIDelegate view) {
		getContentPane().removeAll();
		getContentPane().add((JPanel) view);
		history.registerView(view);
	}
	
	/**
	 * 
	 */
	public void refresh() {
		getContentPane().repaint();
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void back() throws Exception {
		close();
		load(history.back());
	}
	
	/**
	 * @throws Exception 
	 */
	public void close() throws Exception {
		if (getContentPane().getComponentCount() == 1) {
			((GUIDelegate) getContentPane().getComponent(0)).close();
		}
		else {
			throw new Exception("Too many components to close");
		}
	}
	
	/**
	 * @throws Exception
	 */
	public void quit() throws Exception {
		while (history.size() > 0) {
			close();
			history.back();
		}
	}

	/**
	 * Get the dimensions
	 *
	 * @return the dimensions
	 */
	public Dimension getDimensions() {
		return getSize();
	}
	
}
