package com.inpeace.actions;

import java.awt.Point;

import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.entities.AbstractEntity;

/**
 * @author lareina
 *
 */
public class AnimateEntity extends AbstractEntityAction {
	
	Point[] positions;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3084061812846073115L;

	public AnimateEntity(AbstractEntity entity, Point... positions) {
		super(entity);
		this.positions = positions;
	}

	@Override
	public void execute() {
		MailRoom.getInstance().postRequest(PropertyName.FOREGROUND_OBJECT_ENTITY, getEntity(), RequestType.CHANGE_PROPERTY);
	}

}
