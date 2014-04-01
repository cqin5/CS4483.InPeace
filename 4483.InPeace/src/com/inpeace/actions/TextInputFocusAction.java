package com.inpeace.actions;

import com.inpeace.entities.AbstractTextInputEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class TextInputFocusAction extends AbstractEntityAction {

	/**   */
	private static final long serialVersionUID = 122512561979149907L;

	/**
	 * Constructs a new MakeTextBoxActiveAction object.
	 *
	 * @param entity
	 */
	public TextInputFocusAction(AbstractTextInputEntity entity) {
		super(entity);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.engine.LogicElement#execute()
	 */
	@Override
	public void execute() {
		
		((AbstractTextInputEntity) getEntity()).setKeyboardFocus(true);
	}

}
