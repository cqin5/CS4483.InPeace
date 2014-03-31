package com.inpeace.actions;

import java.awt.TextField;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class SelectAllTextAction extends AbstractAction {
	
	/**   */
	private TextField field;
	
	/**
	 * Constructs a new SelectTextAction object.
	 *
	 * @param field
	 */
	public SelectAllTextAction(TextField field) {
		this.field = field;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.engine.LogicElement#execute()
	 */
	@Override
	public void execute() {
		field.requestFocus();
		field.selectAll();
	}

}
