package com.inpeace.views;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.controllers.DefaultController;
import com.inpeace.engine.GameProperties;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;
import com.inpeace.states.AbstractState;
import com.inpeace.states.AbstractState.StateType;

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
	private Point mousePosition = new Point(0, 0);

	/**   */
	private StateType stateType = StateType.NONE;

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
	private ArrayList<AbstractEntity> foregroundObjects= null;


	/*
	 * HUD variables.
	 */

	/**   */
	private BufferedImage hudGraphic = null;

	/**   */
	private ArrayList<AbstractEntity> hudObjects = null;

	/**   */
	private ArrayList<Rectangle> hudScreenCoverage = null;


	/*
	 * Overlay variables.
	 */

	/**   */
	private BufferedImage overlayGraphic = null;

	/**   */
	private ArrayList<AbstractEntity> overlayObjects = null;


	/**
	 * Constructs a new View object.
	 *
	 * @param controller
	 */
	public DefaultView() {
		initialiser();
	}

	/**
	 * 
	 */
	public void initialiser() {
		JFrame window = new JFrame(GameProperties.TITLE);
		JPanel panel = (JPanel) window.getContentPane();
		Dimension size = new Dimension(GameProperties.DEFAULT_WIDTH, 
				GameProperties.DEFAULT_HEIGHT);
		panel.setPreferredSize(size);
		panel.setLayout(null);
		
		setBounds(0, 0, size.width, size.height);
		setBackground(Color.BLACK);
		DefaultMouseAdapter adapter = new DefaultMouseAdapter(this);
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		setIgnoreRepaint(true);

		panel.add(this);
		
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		
		requestFocus();
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void repaint() {
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

		try {
			switch (stateType) {
			case SPLASH:
				repaintBackground(g);
				break;
			case DEFAULT:
				repaintBackground(g);
				repaintForeground(g);
				break;
			case IN_GAME:
				repaintBackground(g);
				repaintForeground(g);
				repaintHUD(g);
				break;
			case OVERLAY:
				repaintBackground(g);
				repaintForeground(g);
				repaintHUD(g);
				repaintOverlay(g);
				break;
			default:
				break;
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

		boolean active = false;
		if (stateType == StateType.IN_GAME || stateType == StateType.DEFAULT) {
			active = true;
		}
		if (foregroundObjects != null) {
			for (AbstractEntity object: foregroundObjects) {
				object.paint(g, scrollPosition, mousePosition, active);
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

		boolean active = false;
		if (stateType == StateType.IN_GAME) {
			active = true;
		}
		if (hudObjects != null) {
			for (AbstractEntity object: hudObjects) {
				object.paint(g, scrollPosition, mousePosition, active);
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
		
		boolean active = false;
		if (stateType == StateType.OVERLAY) {
			active = true;
		}
		if (overlayObjects != null) {
			for (AbstractEntity object: hudObjects) {
				object.paint(g, scrollPosition, mousePosition, active);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#update(java.beans.PropertyChangeEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(PropertyChangeEvent e) {

		if (e.getPropertyName().equals(AbstractState.STATE_TYPE)) {
			stateType = (StateType) e.getNewValue();
		}
		else if (e.getPropertyName().equals(DefaultController.HORIZONTAL_SCROLL_POSITION)) {
			scrollPosition = (Integer) e.getNewValue();
		}
		else if (e.getPropertyName().equals(DefaultController.BACKGROUND_IMAGE_NAME)) {
			try {
				background = Librarian.getInstance().getBackground(e.getNewValue().toString());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (e.getPropertyName().equals(DefaultController.FOREGROUND_OBJECTS)) {
			foregroundObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(DefaultController.HUD_GRAPHIC_SPRITE_CODE)) {
			try {
				hudGraphic = Librarian.getInstance().getSprite((String) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(DefaultController.HUD_OBJECTS)) {
			hudObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(DefaultController.OVERLAY_GRAPHIC_SPRITE_CODE)) {
			try {
				overlayGraphic = Librarian.getInstance().getSprite((String) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(DefaultController.OVERLAY_OBJECTS)) {
			overlayObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
	}

	/**
	 * @param p
	 * @return
	 */
	public AbstractEntity getEntityAt(Point p) {
		switch (stateType) {
		case IN_GAME:
			boolean hudSpace = false;
			if (hudScreenCoverage != null) {
				for (Rectangle bound: hudScreenCoverage) {
					if (bound.contains(p)) {
						hudSpace = true;
						break;
					}
				}
			}
			if (hudSpace) {
				if (hudObjects != null) {
					for (AbstractEntity entity: hudObjects) {
						if (entity.contains(p)) {
							return entity;
						}
					}
				}
				break;
			}
			//Fall through is on purpose
		case DEFAULT:
			if (foregroundObjects != null) {
				for (AbstractEntity entity: foregroundObjects) {
					if (entity.contains(p)) {
						return entity;
					}
				}
			}
			break;
		case OVERLAY:
			if (overlayObjects != null) {
				for (AbstractEntity entity: overlayObjects) {
					if (entity.contains(p)) {
						return entity;
					}
				}
			}
			break;
		default:
			break;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#refresh()
	 */
	@Override
	public void refresh() {
		repaint();
	}

	/**
	 * @param x
	 */
	public void sideScroll(int x) {
		int newScroll = scrollPosition + x;
		if ((background.getWidth() - newScroll) < GameProperties.DEFAULT_WIDTH) {
			newScroll = background.getWidth() - GameProperties.DEFAULT_WIDTH;
		}
		MailRoom.getInstance().postRequest(DefaultController.HORIZONTAL_SCROLL_POSITION, newScroll, 
				RequestType.CHANGE_PROPERTY);
	}


	/**
	 * 
	 * 
	 * @author  James Anderson
	 * @version 1.0
	 * @since   26 Mar 2014
	 */
	private class DefaultMouseAdapter extends MouseAdapter {

		/**   */
		private DefaultView view;

		/**   */
		private AbstractEntity pressedEntity;

		/**   */
		private int dragPosX;

		/**
		 * Constructs a new DefaultMouseAdapter object.
		 *
		 * @param view
		 */
		public DefaultMouseAdapter(DefaultView view) {
			this.view = view;
			dragPosX = -1;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		public void mousePressed(MouseEvent e) {
			pressedEntity = view.getEntityAt(e.getPoint());
			if (pressedEntity != null) {
				pressedEntity.setPressed(true);
				pressedEntity.press();
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
		 */
		public void mouseReleased(MouseEvent e) {
			if (pressedEntity != null) {
				pressedEntity.setPressed(false);

			}
			dragPosX = -1;

		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
		 */
		public void mouseDragged(MouseEvent e) {
			if (dragPosX >= 0) {
				view.sideScroll(dragPosX - e.getX());
			}
			dragPosX = e.getX();
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
		 */
		public void mouseMoved(MouseEvent e) {
			mousePosition = e.getPoint();
		}
	}

}
