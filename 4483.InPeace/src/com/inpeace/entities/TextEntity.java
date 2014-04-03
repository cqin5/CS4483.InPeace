package com.inpeace.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.GameProperties;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class TextEntity extends AbstractEntity {

	/**   */
	private static final long serialVersionUID = -4902629258857434286L;

	/**   */
	private String text;

	/**   */
	private Color fontColour;

	/**   */
	private Font font;
	
	private float fontSize;

	/**
	 * Constructs a new TextEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param hotKey
	 * @param bounds
	 */
	public TextEntity(int depth, Point position, String text) {

		super(depth, null, '\u0000', new Rectangle(position.x, position.y, 0, 0));

		setText(text);
	}

	/**
	 * Set the text
	 *
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Set the fontColour
	 *
	 * @param fontColour the fontColour to set
	 */
	public void setFontColour(Color fontColour) {
		this.fontColour = fontColour;
	}

	/**
	 * Set the font
	 *
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @param size
	 */
	public void setFontSize(float size) {
		this.fontSize = size;
		font = font.deriveFont(size);
	}
	
	/**
	 * Toggle visibility
	 */
	public void toggleVisible() {
		
		if (this.font.getSize() >= 0) {
			this.font = font.deriveFont(this.fontSize);
		}
		else {
			this.setFontSize((float) 0.0);
		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		if (new Rectangle(scrollPosition, 0, GameProperties.DEFAULT_WIDTH, GameProperties.DEFAULT_HEIGHT).
				contains(getBounds())) {

			g.setColor(fontColour);
			g.setFont(font);
			g.drawString(text, getPosition().x - scrollPosition, getPosition().y - font.getSize());
		}
	}

}
