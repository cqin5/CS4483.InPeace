package com.inpeace.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   20 Mar 2014
 */
public class GraphicsManager extends Canvas {

	/**   */
	private static final long serialVersionUID = -769022227591869099L;
	
	/**   */
	private BackgroundController background;
	
	/**   */
	private ForegroundController foreground;
	
	private HUDController hud;
	
	/**   */
	private OverlayController overlay;
	
	/**   */
	private BufferStrategy buffer;
	
	public GraphicsManager(String title, Dimension size) {
		super();
		background = new BackgroundController();
		foreground = new ForegroundController();
		hud = new HUDController();
		overlay = new OverlayController();
		
		JFrame window = new JFrame(title);
		JPanel panel = (JPanel) window.getContentPane();
		panel.setPreferredSize(size);
		panel.setLayout(null);
		
		setBounds(0, 0, size.width, size.height);
		setIgnoreRepaint(true);
		panel.add(this);
		
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		
	}
	
	public void repaint() {
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		g.setColor(Color.black);
		
		background.repaint(g);
		foreground.repaint(g);
		hud.repaint(g);
		overlay.repaint(g);

		g.dispose();
		buffer.show();
	}
	
	/**
	 * 
	 * @param view
	 */
	public void setState(AbstractState state) {
		
		//TODO: code to change graphics models to meet new state
		
	}

	/**
	 * Get the dimensions
	 *
	 * @return the dimensions
	 */
	public Dimension getSize() {
		return getSize();
	}
	
}
