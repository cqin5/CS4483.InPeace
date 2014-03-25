package com.inpeace.views;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.engine.GameProperties;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.AbstractEntityGraphic;
import com.inpeace.graphics.ImageEntityGraphic;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   25 Mar 2014
 */
public class MainView extends Canvas implements AbstractView {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -1745144542387224115L;
	
	/**   */
	private BufferStrategy buffer;
	
	/** Type of state (0 = splash, 1 = menu, 2 = in game, 3 = overlay)  */
	private int stateType;
	
	/**   */
	//TODO: determine what to do about window size
	private static final Dimension size = new Dimension(GameProperties.DEFAULT_WIDTH,
			GameProperties.DEFAULT_HEIGHT);

	/**   */
	private final GraphicsController controller;
	
	
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
	private Iterator<Entry<Integer, ImageEntityGraphic>> characterIterator = null;
	
	/**   */
	private Iterator<Entry<Integer, AbstractEntityGraphic>> foregroundObjectIterator = null;
	
	
	/*
	 * HUD variables.
	 */
	
	/**   */
	private BufferedImage hudGraphic = null;
	
	/**   */
	private Iterator<Entry<Integer, AbstractEntityGraphic>> hudObjectIterator = null;
	
	
	/*
	 * Overlay variables.
	 */
	
	/**   */
	private BufferedImage overlayGraphic = null;
	
	/**   */
	private Iterator<Entry<Integer, AbstractEntityGraphic>> overlayObjectIterator = null;
	
	
	/**
	 * Constructs a new View object.
	 *
	 * @param controller
	 */
	public MainView(GraphicsController controller) {
		this.controller = controller;
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
		
		try {
			repaintBackground(g);
			if (stateType > 0) {
				repaintForeground(g);

			}
			if (stateType > 1) {
				repaintHUD(g);
			}
			if (stateType > 2) {
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
		
		g.drawImage(background.getSubimage(scrollPosition, GameProperties.DEFAULT_VERTICAL_ALIGNMENT,
				GameProperties.DEFAULT_WIDTH, GameProperties.DEFAULT_HEIGHT), 0, 0, null);
	}

	/**
	 * @param g
	 * @throws ResourceAccessException 
	 */
	private void repaintForeground(Graphics2D g) throws ResourceAccessException {				
		
		while (foregroundObjectIterator.hasNext()) {
			foregroundObjectIterator.next().getValue().paint(g);
		}
		
		while (characterIterator.hasNext()) {
			characterIterator.next().getValue().paint(g);
		}
	}

	/**
	 * @param g
	 * @throws ResourceAccessException 
	 */
	private void repaintHUD(Graphics2D g) throws ResourceAccessException {

		g.drawImage(hudGraphic, 0, 0, null);
		
		while (hudObjectIterator.hasNext()) {
			hudObjectIterator.next().getValue().paint(g);
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
		
		int x = (GameProperties.DEFAULT_WIDTH / 2) - (overlayGraphic.getWidth() / 2);
		int y = (GameProperties.DEFAULT_HEIGHT / 2) - (overlayGraphic.getHeight() / 2);
		g.drawImage(overlayGraphic, x, y, null);
		
		while (overlayObjectIterator.hasNext()) {
			overlayObjectIterator.next().getValue().paint(g);
		}

	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#update(java.beans.PropertyChangeEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(PropertyChangeEvent e) {
		
		if (e.getPropertyName().equals(GraphicsController.HORIZONTAL_SCROLL_POSITION)) {
			int position = (Integer) e.getNewValue();
			
			if ((background.getWidth() - position) < GameProperties.DEFAULT_WIDTH) {
				position = background.getWidth() - GameProperties.DEFAULT_WIDTH;
				if (scrollPosition != position) {
					controller.setScrollPosition(position);
				}
			}
			else if (scrollPosition != position) {
				scrollPosition = position;
				repaint();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.BACKGROUND_IMAGE_NAME)) {
			try {
				background = Librarian.getInstance().getBackground(e.getNewValue().toString());
				repaint();
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.CHARACTER_ITERATOR)) {
			characterIterator = (Iterator<Entry<Integer, ImageEntityGraphic>>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.FOREGROUND_OBJECT_ITERATOR)) {
			foregroundObjectIterator = (Iterator<Entry<Integer, AbstractEntityGraphic>>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.HUD_GRAPHIC_SPRITE_CODE)) {
			try {
				hudGraphic = Librarian.getInstance().getSprite((Long) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.HUD_OBJECT_ITERATOR)) {
			hudObjectIterator = (Iterator<Entry<Integer, AbstractEntityGraphic>>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE)) {
			try {
				overlayGraphic = Librarian.getInstance().getSprite((Long) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(GraphicsController.OVERLAY_OBJECT_ITERATOR)) {
			overlayObjectIterator = (Iterator<Entry<Integer, AbstractEntityGraphic>>) e.getNewValue();
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
