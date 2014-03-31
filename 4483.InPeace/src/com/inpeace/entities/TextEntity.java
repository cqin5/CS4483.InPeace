package com.inpeace.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

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
	private String text;
	
	/**   */
	private Color fontColour;
	
	/**   */
	private Font font;
	
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
		font = font.deriveFont(size);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		
		g.setColor(fontColour);
		g.setFont(font);
		g.drawString(text, getPosition().x, getPosition().y - font.getSize());
		
	}

}
