package com.inpeace.actions;

import com.inpeace.entities.AbstractEntity;
import com.inpeace.entities.TextEntity;

public class TextAction extends AbstractEntityAction {

	
	/**   */
	private static final long serialVersionUID = 886807605079651584L;
	
	public TextAction(TextEntity entity) {
		super(entity);
	}

	@Override
	public void execute() {
		
		((TextEntity) getEntity()).toggleVisible();
		
	}

	
	
	
}
