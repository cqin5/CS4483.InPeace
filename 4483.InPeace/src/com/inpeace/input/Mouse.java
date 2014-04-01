package com.inpeace.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.inpeace.entities.AbstractEntity;
import com.inpeace.entities.AbstractScrollableEntity;
import com.inpeace.views.AbstractView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class Mouse extends MouseAdapter {
	
	/**   */
	private static Mouse instance = null;

	/**   */
	private AbstractView view;

	/**   */
	private AbstractEntity pressedEntity;

	/**   */
	private int dragPosX;
	private int dragPosY;

	/**
	 * Constructs a new DefaultMouseAdapter object.
	 *
	 * @param view
	 */
	private Mouse() {
		dragPosX = -1;
		dragPosY = -1;
		view = null;
		pressedEntity = null;
	}
	
	/**
	 * @return
	 */
	public static Mouse getInstance() {
		if (instance == null) {
			instance = new Mouse();
		}
		return instance;
	}

	/**
	 * Set the view
	 *
	 * @param view the view to set
	 */
	public void setCurrentView(AbstractView view) {
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		pressedEntity = view.getEntityAt(e.getPoint());
		if (pressedEntity != null) {
			pressedEntity.setDepressed(true);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		if (pressedEntity != null) {
			pressedEntity.setDepressed(false);
			pressedEntity.press();
			pressedEntity = null;
			Keyboard.getInstance().clearFocus();
		}
		dragPosX = -1;
		dragPosY = -1;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		AbstractScrollableEntity scrollable = view.getScrollableAt(e.getPoint());
		if (scrollable != null) {
			scrollable.scroll(e.getPoint());
		}
		else {
			if (dragPosX >= 0) {
				view.scroll(dragPosX - e.getX(), dragPosY - e.getY());
			}
			if (pressedEntity != null) {
				pressedEntity.setDepressed(false);
				pressedEntity = null;
			}
		}
		dragPosX = e.getX();
		dragPosY = e.getY();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		view.setMousePosition(e.getPoint());
	}
}
