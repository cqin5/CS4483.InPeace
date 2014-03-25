package com.inpeace.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.states.AbstractState;

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

	/**   */
	private HUDController hud;

	/**   */
	private OverlayController overlay;

	/**   */
	private BufferStrategy buffer;

	/** Type of state (0 = splash, 1 = menu, 2 = in game, 3 = overlay)  */
	private int stateType;

	/**
	 * Constructs a new GraphicsManager object.
	 *
	 * @param title
	 * @param size
	 */
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

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void repaint() {
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		g.setColor(Color.black);

		background.repaint(g);
		if (getStateType() > 0) {
			foreground.repaint(g);
		}
		if (getStateType() > 1) {
			hud.repaint(g);
		}
		if (getStateType() > 2) {
			overlay.repaint(g);
		}

		g.dispose();
		buffer.show();
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(AbstractState state) {

		switch (state.getType()) {

		case 0:
			background.loadState(state);
			break;

		case 1:
			background.loadState(state);
			foreground.loadState(state);
			break;
		case 2:
			background.loadState(state);
			foreground.loadState(state);
			hud.loadState(state);
			break;
		case 3:
			overlay.loadState(state);
			break;
		}

		setStateType(state.getType());

	}

	/**
	 * Get the dimensions
	 *
	 * @return the dimensions
	 */
	@Override
	public Dimension getSize() {
		return getSize();
	}


	/**
	 * Get the stateType
	 *
	 * @return the stateType
	 */
	public int getStateType() {
		return stateType;
	}

	/**
	 * Set the stateType
	 *
	 * @param stateType the stateType to set
	 */
	public void setStateType(int stateType) {
		this.stateType = stateType;
	}


}
