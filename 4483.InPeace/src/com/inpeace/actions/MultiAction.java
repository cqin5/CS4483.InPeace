package com.inpeace.actions;

import com.inpeace.engine.LogicElement;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class MultiAction extends AbstractAction {
	
	/**   */
	private LogicElement[] elements;
	
	public MultiAction(LogicElement... elements) {
		this.elements = elements;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.actions.AbstractAction#performAction()
	 */
	@Override
	public void execute() {
		
		for (LogicElement element: elements) {
			element.execute();
		}
	}

}
