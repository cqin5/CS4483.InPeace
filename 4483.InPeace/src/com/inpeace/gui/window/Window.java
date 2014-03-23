package com.inpeace.gui.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	
	/**   */
	private Dimension size;

	/**
	 * Constructs a new Window object.
	 *
	 * @param title
	 * @param size
	 */
	public Window(String title, Dimension size) {
		super();
		history = new History();
		this.size = size;
		
		setTitle(title);
		setSize(this.size);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.black);
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
		/*
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (!device.isFullScreenSupported()) {
			device.setFullScreenWindow(this);
		} else {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			//setResizable(false);
		}
		*/
	}
	
	/**
	 * Constructs a new Window object.
	 *
	 * @param title
	 * @param width
	 * @param height
	 */
	public Window(String title, int width, int height) {
		this(title, new Dimension(width, height));
	}
	
	/**
	 * @param view
	 * @param window
	 */
	public void load(GUIDelegate view) {
		getContentPane().removeAll();
		getContentPane().add((JPanel) view, BorderLayout.CENTER);
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
