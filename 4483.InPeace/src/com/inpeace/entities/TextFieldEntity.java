package com.inpeace.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

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

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		
		String str = "";
		for (int i = 0; i < charCount; i++) {
			str += text[i];
		}
		if (isKeyboardFocus()) {
			if (getNextFlash() >= System.currentTimeMillis()) {
				cursor = !cursor;
			}
			if (cursor) {
				str += "|";
			}
		}
		
		g.setColor(fontColour);
		g.setFont(font);
		g.drawString(str, getPosition().x, getPosition().y);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractTextInputEntity#keyPress(char)
	 */
	@Override
	public void keyPress(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == '\u0008') {
			charCount--;
			if (charCount < 0) {
				charCount = 0;
			}
			text[charCount] = '\u0000';
		}
		else if (e.getKeyCode() == '\n') {
			setKeyboardFocus(false);
			enterButton.press();
		}
		else if ((key >= '0' && key <= '9') || (key >= 'a' && key <= 'z') 
				|| (key >= 'A' && key <= 'Z')) {
			if (charCount + 1 < text.length) {
				text[charCount] =  key;
				charCount++;
			}
		}
		else if (key == '_' || key == '-' || key == '@' || key == '#' || key == '$') {
			if (charCount + 1 < text.length) {
				text[charCount] =  key;
				charCount++;
			}
		}
	}

}
