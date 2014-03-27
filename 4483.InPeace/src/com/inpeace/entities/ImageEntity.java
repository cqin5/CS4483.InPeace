package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.GameProperties;
import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public class ImageEntity extends AbstractEntity {
	
	/**   */
	private String defaultSpriteCode;
	private String mouseOverSpriteCode;
	private String mousePressSpriteCode;

	/**   */
	private BufferedImage defaultImage;
	private BufferedImage mouseOverImage;
	private BufferedImage mousePressImage;

	/**   */
	private Point position;

	/**
	 * Constructs a new ImageEntity object.
	 *
	 * @param depth
	 * @param actions
	 * @param spriteCode
	 * @param mouseOverSpriteCode
	 */
	public ImageEntity(int depth, AbstractAction pressAction, AbstractAction enterAction, 
			String defaultSpriteCode, String mouseOverSpriteCode, String mousePressSpriteCode,
			Point position) {
		super(depth, pressAction, enterAction);
		this.defaultSpriteCode = defaultSpriteCode;
		this.mouseOverSpriteCode = mouseOverSpriteCode;
		this.mousePressSpriteCode = mousePressSpriteCode;
		this.position = position;
		this.defaultImage = null;
		this.mouseOverImage = null;
		this.mousePressImage = null;
		setBounds();

	}

	/**
	 * @return
	 */
	public String getDefaultSpriteCode() {
		return defaultSpriteCode;
	}
	
	/**
	 * @return
	 */
	public String getMouseOverSpriteCode() {
		return mouseOverSpriteCode;
	}
	
	/**
	 * @return
	 */
	public String getMousePressSpriteCode() {
		return mousePressSpriteCode;
	}

	/**
	 * Get the position
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}
	
	private void setBounds() {
		String[] chunks = defaultSpriteCode.split("-");
		bounds = new Rectangle(position.x, position.y, Integer.parseInt(chunks[3]), 
				Integer.parseInt(chunks[4]));
	}

	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#update(com.inpeace.graphics.AbstractEntityGraphic)
	 */
	@Override
	public boolean update(AbstractEntity graphic) throws IncompatibleObjectException {
		if (graphic.getClass() != ImageEntity.class) {
			throw new IncompatibleObjectException("ImageEntityGraphic: unable to update,"
					+ " paramater class does not match");
		}
		boolean change = false;
		if (!defaultSpriteCode.equals(((ImageEntity) graphic).getDefaultSpriteCode())) {
			defaultSpriteCode = ((ImageEntity) graphic).getDefaultSpriteCode();
			change = true;
		}
		if (!mouseOverSpriteCode.equals(((ImageEntity) graphic).getMouseOverSpriteCode())) {
			mouseOverSpriteCode = ((ImageEntity) graphic).getMouseOverSpriteCode();
			change = true;
		}
		if (!mousePressSpriteCode.equals(((ImageEntity) graphic).getMousePressSpriteCode())) {
			mousePressSpriteCode = ((ImageEntity) graphic).getMousePressSpriteCode();
			change = true;
		}
		if (position != ((ImageEntity) graphic).getPosition()) {
			position = ((ImageEntity) graphic).getPosition();
			change = true;
		}
		if (change) {
			setBounds();
		}
		return change;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#paint(java.awt.Graphics2D)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mouse, boolean active) throws ResourceAccessException {
		int x = position.x - scrollPosition;
		if (active && isMousePress()) {
			if (mousePressImage == null) {
				mousePressImage = Librarian.getInstance().getSprite(mousePressSpriteCode);
			}
			if (x < (GameProperties.DEFAULT_WIDTH + mousePressImage.getWidth()) 
					&& x > (0 - mousePressImage.getWidth())) {
				g.drawImage(mousePressImage , x, position.y, null);
			}
		}
		else if (active && contains(mouse)) {
			if (mouseOverImage == null) {
				mouseOverImage = Librarian.getInstance().getSprite(mouseOverSpriteCode);
			}
			if (x < (GameProperties.DEFAULT_WIDTH + mouseOverImage.getWidth()) 
					&& x > (0 - mouseOverImage.getWidth())) {
				g.drawImage(mouseOverImage , x, position.y, null);
			}
		}
		else {
			if (defaultImage == null) {
				defaultImage = Librarian.getInstance().getSprite(defaultSpriteCode);
			}
			if (x < (GameProperties.DEFAULT_WIDTH + defaultImage.getWidth()) 
					&& x > (0 - defaultImage.getWidth())) {
				g.drawImage(defaultImage , x, position.y, null);
			}
		}
	}
}
