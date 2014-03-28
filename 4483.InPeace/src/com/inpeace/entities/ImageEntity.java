package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.GameProperties;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteSheet;
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

	/**   */
	private BufferedImage[][] images;

	/**   */
	private int versionCount;

	private int highlightLine;
	private int pressedLine;

	/**   */
	private Point position;

	/**   */
	private int currentVersion;

	/**
	 * Constructs a new ImageEntity object.
	 *
	 * @param depth
	 * @param actions
	 * @param spriteCode
	 * @param mouseOverSpriteCode
	 * @throws EntityException 
	 */
	public ImageEntity(int depth, AbstractAction pressAction, AbstractAction enterAction, 
			String defaultSpriteCode, boolean highlightable, boolean pressable, 
			int versionCount, Point position) throws EntityException {

		super(depth, pressAction, enterAction);
		this.defaultSpriteCode = defaultSpriteCode;
		this.versionCount = versionCount;
		this.position = position;
		int lines = 1;
		if (highlightable && pressable) {
			highlightLine = 1;
			pressedLine = 2;
			lines = 3;
		}
		else if (highlightable || pressable) {
			lines = 2;
			if (highlightable) {
				highlightLine = 1;
			}
			else {
				pressedLine = 1;
			}
		}
		this.images = new BufferedImage[lines][versionCount];
		this.currentVersion = 0;
		setBounds();

	}

	/**
	 * @return
	 */
	public String getDefaultSpriteCode() {
		return defaultSpriteCode;
	}

	/**
	 * Get the position
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * 
	 */
	private void setBounds() {
		String[] chunks = defaultSpriteCode.split("-");
		bounds = new Rectangle(position.x, position.y, Integer.parseInt(chunks[3]), 
				Integer.parseInt(chunks[4]));
	}

	/**
	 * Set the currentVersion
	 *
	 * @param currentVersion the currentVersion to set
	 * @throws EntityException 
	 */
	public void setCurrentVersion(int currentVersion) throws EntityException {
		if (currentVersion < 0 || currentVersion > versionCount) {
			throw new EntityException("Unable to set image version to " + currentVersion + ", the version"
					+ " must be between 0 and " + versionCount + " (ImageEntity)");
		}
		this.currentVersion = currentVersion;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.graphics.AbstractEntityGraphic#paint(java.awt.Graphics2D)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mouse, boolean active) 
			throws ResourceAccessException {
		int x = position.x - scrollPosition;
		int width = SpriteSheet.getSpriteWidth(defaultSpriteCode);
		if (x < (GameProperties.DEFAULT_WIDTH + width) && x > (0 - width)) {
			if (active && isPressed()) {
				if (images[pressedLine][currentVersion] == null) {
					String code = SpriteSheet.convertCode(defaultSpriteCode, pressedLine, currentVersion);
					images[pressedLine][currentVersion] = Librarian.getInstance().getSprite(code);
				}
				g.drawImage(images[pressedLine][currentVersion] , x, position.y, null);
			}
			else if (active && contains(mouse)) {
				if (images[highlightLine][currentVersion] == null) {
					String code = SpriteSheet.convertCode(defaultSpriteCode, highlightLine, currentVersion);
					images[highlightLine][currentVersion] = Librarian.getInstance().getSprite(code);
				}
				g.drawImage(images[highlightLine][currentVersion] , x, position.y, null);
			}
			else {
				if (images[0][currentVersion] == null) {
					String code = SpriteSheet.convertCode(defaultSpriteCode, 0, currentVersion);
					images[0][currentVersion] = Librarian.getInstance().getSprite(code);
				}
				g.drawImage(images[0][currentVersion] , x, position.y, null);
			}
		}
	}

}
