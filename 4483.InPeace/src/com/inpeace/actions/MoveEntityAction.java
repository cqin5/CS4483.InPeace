package com.inpeace.actions;

import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.entities.AbstractEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class MoveEntityAction extends AbstractEntityAction {

	/**   */
	private Rectangle confines;
	
	/**   */
	private Point translation;

	/**
	 * Constructs a new MoveEntityAction object.
	 *
	 * @param entity
	 */
	public MoveEntityAction(AbstractEntity entity, Point translation, Rectangle motionConfines) {
		super(entity);
		this.translation = translation;
		this.confines = motionConfines;
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.engine.LogicElement#execute()
	 */
	@Override
	public void execute() {
		Rectangle bounds = getEntity().getBounds();
		Point position = getEntity().getPosition();
		Point newPosition = new Point(position.x + translation.x, position.y + translation.y);
		bounds.add(newPosition);

		if (confines.contains(bounds)) {
			getEntity().setPosition(newPosition);
		}
	}
}
