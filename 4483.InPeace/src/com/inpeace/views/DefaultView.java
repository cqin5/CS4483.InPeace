package com.inpeace.views;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inpeace.GameProperties;
import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.StateManager;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.entities.AbstractScrollableEntity;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.input.Keyboard;
import com.inpeace.input.Mouse;
import com.inpeace.library.Librarian;
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
	private Point origin = new Point(0,0);
	
	/**   */
	private double scaleRatio = 1.0;

	/**   */
	private Point mousePosition = new Point(-1, -1);

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

	/*
	 * Audio variables.
	 */

	/**   */
	private Clip backgroundMusic = null;

	/**   */
	private Queue<Clip> soundEffects = new LinkedList<Clip>();

	/*
	 * Settings variables.
	 */

	/**   */
	private float musicVolume;

	/**   */
	private float fxVolume;

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
		JFrame window = GameProperties.DEFAULT_FRAME;
		window.setTitle(GameProperties.TITLE);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				StateManager.getInstance().quit();
			}        
		});
		window.setExtendedState( window.getExtendedState() | Frame.MAXIMIZED_VERT | Frame.MAXIMIZED_HORIZ);

		JPanel panel = (JPanel) window.getContentPane();
		panel.setLayout(new BorderLayout());

		setBounds(0, 0, 600, (int) (600 / 1.778));
		panel.setBackground(Color.BLACK);
		setIgnoreRepaint(true);

		addMouseListener(Mouse.getInstance());
		addMouseMotionListener(Mouse.getInstance());
		Mouse.getInstance().setCurrentView(this);
		addKeyListener(Keyboard.getInstance());

		panel.add(this, BorderLayout.CENTER);

		window.pack();
		//window.setResizable(false);
		window.setVisible(true);

		createBufferStrategy(2);
		buffer = getBufferStrategy();

		requestFocus();
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void setOrigin(int x, int y) {
		origin.x = x;
		origin.y = y;
	}
	
	public void setScaleRatio(double ratio) {
		scaleRatio = ratio;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void repaint() {
		
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		
		Dimension size = getSize();
		g.drawRect(0, 0, size.width, size.width);
		
		double ratiox = (double) size.width / (double) GameProperties.DEFAULT_WIDTH;
		double ratioy = (double) size.height / (double) GameProperties.DEFAULT_HEIGHT;
		double ratio = 1.0;
        if (ratiox <= ratioy) {
        	ratio = ratiox;
        }
        else {
        	ratio = ratioy;
        }
        
        int x = (size.width - (int) (GameProperties.DEFAULT_WIDTH * ratio)) /2;
        int y = (size.height - (int) (GameProperties.DEFAULT_HEIGHT * ratio)) / 2;
        
        setOrigin(x, y);
        setScaleRatio(ratio);
        
        g.translate(x, y);
        g.scale(ratio, ratio);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
		try {
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
		} finally {	
			g.dispose();
		}
		buffer.show();
	}

	/**
	 * @param g
	 */
	private void repaintBackground(Graphics2D g) {
		if (background != null) {
			try {
				g.drawImage(background.getSubimage(scrollPosition, 0, GameProperties.DEFAULT_WIDTH,
						GameProperties.DEFAULT_HEIGHT), 0, 0, null);
			} catch (RasterFormatException e) {
				System.out.print(background.getWidth() + ", " + GameProperties.DEFAULT_WIDTH + ", " + scrollPosition + "\n");
				e.printStackTrace();
			}
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
			for (AbstractEntity object: overlayObjects) {
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

		if (e.getPropertyName().equals(PropertyName.STATE_TYPE.toString())) {
			stateType = (StateType) e.getNewValue();
		}
		else if (e.getPropertyName().equals(PropertyName.HORIZONTAL_SCROLL_POSITION.toString())) {
			scrollPosition = (Integer) e.getNewValue();
		}
		else if (e.getPropertyName().equals(PropertyName.BACKGROUND_IMAGE_NAME.toString())) {
			try {
				background = Librarian.getInstance().getBackground(e.getNewValue().toString());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(PropertyName.FOREGROUND_OBJECTS.toString())) {
			foregroundObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(PropertyName.HUD_GRAPHIC_SPRITE_CODE.toString())) {
			try {
				hudGraphic = Librarian.getInstance().getSprite((SpriteCode) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(PropertyName.HUD_OBJECTS.toString())) {
			hudObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
		else if (e.getPropertyName().equals(PropertyName.OVERLAY_GRAPHIC_SPRITE_CODE.toString())) {
			try {
				overlayGraphic = Librarian.getInstance().getSprite((SpriteCode) e.getNewValue());
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(PropertyName.OVERLAY_OBJECTS.toString())) {
			overlayObjects = (ArrayList<AbstractEntity>) e.getNewValue();
		}
		if (e.getPropertyName().equals(PropertyName.MUSIC_NAME.toString())) {
			try {
				if (backgroundMusic != null) {
					backgroundMusic.stop();
				}
				backgroundMusic = Librarian.getInstance().getSound((String) e.getNewValue());
				if (backgroundMusic != null) {
					FloatControl volume = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(musicVolume);
					backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
				}
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(PropertyName.SOUND_EFFECT.toString())) {
			try {
				Clip clip = Librarian.getInstance().getSound((String) e.getNewValue());
				if (clip != null) {
					soundEffects.add(clip);
				}
			} catch (ResourceAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getPropertyName().equals(PropertyName.MUSIC_VOLUME.toString())) {
			musicVolume = (float) e.getNewValue();
		}
		else if (e.getPropertyName().equals(PropertyName.SOUND_EFFECTS_VOLUME.toString())) {
			fxVolume = (float) e.getNewValue();
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#getEntityAt(java.awt.Point)
	 */
	@Override
	public AbstractEntity getEntityAt(Point p) {
		p.x -= origin.x;
		p.y -= origin.y;
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
	 * @see com.inpeace.views.AbstractView#getScrollableAt(java.awt.Point)
	 */
	@Override
	public AbstractScrollableEntity getScrollableAt(Point p) {
		AbstractEntity entity = getEntityAt(p);
		if (entity instanceof AbstractScrollableEntity) {
			return (AbstractScrollableEntity) entity;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#refresh()
	 */
	@Override
	public void refresh() {
		repaint();

		if (soundEffects != null) {
			for (Clip clip: soundEffects) {
				FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(fxVolume);
				clip.start();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#scroll(int, int)
	 */
	@Override
	public void scroll(int x, int y) {
		int newScroll = scrollPosition + (int) (x / scaleRatio);
		int max = background.getWidth() - GameProperties.DEFAULT_WIDTH - 1;
		if (newScroll > max) {
			newScroll = max;
		}
		else if (newScroll < 0) {
			newScroll = 0;
		}
		if (newScroll != scrollPosition) {
			MailRoom.getInstance().postRequest(PropertyName.HORIZONTAL_SCROLL_POSITION, newScroll, 
					RequestType.CHANGE_PROPERTY);
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.views.AbstractView#setMousePosition(java.awt.Point)
	 */
	@Override
	public void setMousePosition(Point p) {
		this.mousePosition = p;		
	}

}
