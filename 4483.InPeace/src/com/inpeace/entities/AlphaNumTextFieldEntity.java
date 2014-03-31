package com.inpeace.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.inpeace.actions.SelectAllTextAction;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.input.EnterListener;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   30 Mar 2014
 */
public class AlphaNumTextFieldEntity extends AbstractEntity {

	/**   */
	private TextField field;

	/**
	 * Constructs a new TextFieldEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param bounds
	 */
	public AlphaNumTextFieldEntity(int depth, Rectangle bounds, ImageEntity enterLinkedButton,
			String initialText, Color background, int maxChar) {
		super(depth, null, bounds);
		field = new TextField(initialText, maxChar);
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
						|| c != KeyEvent.VK_ENTER)) {
					e.consume();  // ignore key
				}
			}
		});
		field.setBounds(bounds);
		field.setBackground(background);
		field.setColumns(maxChar);
		field.addKeyListener(new EnterListener(enterLinkedButton));
		field.setIgnoreRepaint(true);
		field.selectAll();
		field.requestFocus();
		field.setVisible(true);

		setMousePressAction(new SelectAllTextAction(field));
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		
		field.setLocation(field.getX() + scrollPosition, field.getY());
		field.paint(g);
	}

}
