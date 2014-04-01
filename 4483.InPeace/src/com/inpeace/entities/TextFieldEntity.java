package com.inpeace.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.GameProperties;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteCode;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   30 Mar 2014
 */
public class TextFieldEntity extends AbstractTextInputEntity {

	/**   */
	private static final long serialVersionUID = -5394640191673076467L;

	/**   */
	private ImageEntity enterButton;

	/**   */
	private char[] text;
	private int charCount;

	/**   */
	private Color fontColour;

	/**   */
	private Font font;

	/**   */
	private boolean cursor;

	/**
	 * Constructs a new TextFieldEntity object.
	 *
	 * @param depth
	 * @param backgroundSpriteCode
	 * @param position
	 * @param initialFocus
	 * @param linkedButton
	 * @param maxChar
	 * @param fontColour
	 * @param font
	 */
	public TextFieldEntity(int depth, SpriteCode backgroundSpriteCode, Point position, 
			ImageEntity enterButton, int maxChar) {

		super(depth, backgroundSpriteCode, position);

		this.enterButton = enterButton;
		text = new char[maxChar];
		charCount = 0;
		this.fontColour = Color.BLACK;
		this.font = GameProperties.DEFAULT_FONT;
	}

	/**
	 * @param size
	 */
	public void setFontSize(float size) {
		font = font.deriveFont(size);
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
	 * @return
	 */
	public String getText() {
		String str = "";
		for (int i = 0; i < charCount; i++) {
			str += text[i];
		}
		return str;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		if (new Rectangle(scrollPosition, 0, GameProperties.DEFAULT_WIDTH, GameProperties.DEFAULT_HEIGHT).
				contains(getBounds())) {
			String str = "";
			for (int i = 0; i < charCount; i++) {
				str += text[i];
			}
			if (isKeyboardFocus()) {
				if (getNextFlash() <= System.currentTimeMillis()) {
					setNextFlash();
					cursor = !cursor;
				}
				if (cursor) {
					str += "|";
				}
			}

			g.setColor(fontColour);
			g.setFont(font);
			g.drawString(str, getPosition().x - scrollPosition, getPosition().y - font.getSize());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractTextInputEntity#enter()
	 */
	@Override
	public void enter() {
		setKeyboardFocus(false);
		enterButton.press();		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractTextInputEntity#backspace()
	 */
	@Override
	public void backspace() {
		charCount--;
		if (charCount < 0) {
			charCount = 0;
		}
		text[charCount] = '\u0000';		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractTextInputEntity#key(char)
	 */
	@Override
	public void key(char c) {
		if (charCount + 1 < text.length) {
			text[charCount] = c;
			charCount++;
		}		
	}

}
