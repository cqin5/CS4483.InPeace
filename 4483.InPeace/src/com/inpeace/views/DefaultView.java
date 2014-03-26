package com.inpeace.views;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.GameProperties;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.AbstractEntityGraphic;
import com.inpeace.library.Librarian;
import com.inpeace.states.AbstractState;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   25 Mar 2014
 */
public class DefaultView extends Canvas implements AbstractView {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -1745144542387224115L;
	
	/**   */
	private BufferStrategy buffer;
	
	/**   */
	private int stateType = 0;
	
	/**   */
	//TODO: determine what to do about window size
	private static final Dimension size = new Dimension(GameProperties.DEFAULT_WIDTH,
			GameProperties.DEFAULT_HEIGHT);
	
	
	/*
	 * Background variables.
	 */
	
	/**   */
	private BufferedImage background = null;
	
	/**   */
	private int scrollPosition = 0;  //Not only used by background
	
	
	/*
	 * Foreground variables.
	 */
	
	/**   */
	ArrayList<AbstractEntityGraphic> foregroundObjects= null;
	
	
	/*
	 * HUD variables.
	 */
	
	/**   */
	private BufferedImage hudGraphic = null;
	
	/**   */
	ArrayList<AbstractEntityGraphic> hudObjects = null;
	
	
	/*
	 * Overlay variables.
	 */
	
	/**   */
	private BufferedImage overlayGraphic = null;
	
	/**   */
	ArrayList<AbstractEntityGraphic> overlayObjects = null;
	
	
	/**
	 * Constructs a new View object.
	 *
	 * @param controller
	 */
	public DefaultView(GraphicsController controller) {
		initialiser();
	}
	
	/**
	 * 
	 */
	public void initialiser() {
		JFrame window = new JFrame(GameProperties.TITLE);
		JPanel panel = (JPanel) window.getContentPane();
		panel.setPreferredSize(size);
		panel.setLayout(null);

		setBounds(0, 0, size.width, size.height);
		setBackground(Color.BLACK);
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
		
		try {
			repaintBackground(g);
			if (stateType > AbstractState.SPLASH_SCREEN) {
				repaintForeground(g);
			}
			if (stateType == AbstractState.GAME_SCREEN) {
				repaintHUD(g);
			}
			if (stateType == AbstractState.OVERLAY_SCREEN) {
				repaintOverlay(g);
			}
		} catch (ResourceAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.dispose();
		buffer.show();
	}

	/**
	 * @param g
	 */
	private void repaintBackground(Graphics2D g) {
		if (background != null) {
			g.drawImage(background.getSubimage(scrollPosition, 0, GameProperties.DEFAULT_WIDTH,
					GameProperties.DEFAULT_HEIGHT), 0, 0, null);
		}
	}

	/**
	 * @param g
	 * @throws ResourceAccessException 
	 */
	private void repaintForeground(Graphics2D g) throws ResourceAccessException {				
		
		if (foregroundObjects != null) {
			for (AbstractEntityGraphic object: foregroundObjects) {
				object.paint(g, scrollPosition);
			}
		}
	}

	/**
	 * @param g
	 * @throws ResourceAccessException 
	 */
	private void repaintHUD(Graphics2D g) throws ResourceAccessException {

		if (hudGraphic != null) {
			g.drawImage(hudGraphic, 0, 0, null);
		}
		
		if (hudObjects != null) {
			for (AbstractEntityGraphic object: hudObjects) {
				object.paint(g, scrollPosition);
			}
		}
		
	}

	/**
	 * @param g
	 * @throws ResourceAccessException 
	 */
	private void repaintOverlay(Graphics2D g) throws ResourceAccessException {
		
		//Dim screen around overlay
		g.setPaint(new Color(0, 0, 0, 0.75f));
		g.fillRect(0, 0, GameProperties.DEFAULT_WIDTH, GameProperties.DEFAULT_HEIGHT);
		
		if (overlayGraphic != null) {
			int x = (GameProperties.DEFAULT_WIDTH / 2) - (overlayGraphic.getWidth() / 2);
			int y = (GameProperties.DEFAULT_HEIGHT / 2) - (overlayGraphic.getHeight() / 2);
			g.drawImage(overlayGraphic, x, y, null);
		}
		
		if (overlayObjects != null) {
			for (AbstractEntityGraphic object: hudObjects) {
				object.paint(g, scrollPosition);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#update(java.beans.PropertyChangeEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(PropertyChangeEvent e) {
		
		if (e.getPropertyName().equals(GraphicsController.STATE_TYPE)) {
			stateType = (Integer) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.HORIZONTAL_SCROLL_POSITION)) {
			scrollPosition = (Integer) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.BACKGROUND_IMAGE_NAME)) {
			try {
				background = Librarian.getInstance().getBackground(e.getNewValue().toString());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (e.getPropertyName().equals(GraphicsController.FOREGROUND_OBJECTS)) {
			foregroundObjects = (ArrayList<AbstractEntityGraphic>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.HUD_GRAPHIC_SPRITE_CODE)) {
			try {
				hudGraphic = Librarian.getInstance().getSprite((String) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.HUD_OBJECTS)) {
			hudObjects = (ArrayList<AbstractEntityGraphic>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE)) {
			try {
				overlayGraphic = Librarian.getInstance().getSprite((String) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.OVERLAY_OBJECTS)) {
			overlayObjects = (ArrayList<AbstractEntityGraphic>) e.getNewValue();
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#refresh()
	 */
	@Override
	public void refresh() {
		repaint();
	}
	
	//TODO: deal with any form of user input that may end up being put through here

}
