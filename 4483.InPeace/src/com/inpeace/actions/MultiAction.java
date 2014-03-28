package com.inpeace.actions;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class MultiAction extends AbstractAction {
	
	/**   */
	private AbstractAction[] actions;
	
	public MultiAction(AbstractAction... actions) {
		this.actions = actions;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.actions.AbstractAction#performAction()
	 */
	@Override
	public void performAction() {
		
		for (AbstractAction action: actions) {
			action.performAction();
		}
	}

}
