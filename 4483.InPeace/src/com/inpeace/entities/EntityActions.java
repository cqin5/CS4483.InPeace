package com.inpeace.entities;

import com.inpeace.actions.AbstractAction;
import com.inpeace.engine.ActionRegistrar;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class EntityActions {

	/**   */
	private Integer mouseClickID = null;
	
	/**   */
	private Integer mouseReleaseID = null;
	
	/**   */
	private Integer enterID = null;
	
	/**
	 * @param action
	 */
	public void setMouseClickAction(AbstractAction action) {
		mouseClickID = ActionRegistrar.getInstance().registerAction(action);
	}
	
	/**
	 * @param action
	 */
	public void setMouseReleaseAction(AbstractAction action) {
		mouseReleaseID = ActionRegistrar.getInstance().registerAction(action);
	}
	
	/**
	 * @param action
	 */
	public void setEnterAction(AbstractAction action) {
		enterID = ActionRegistrar.getInstance().registerAction(action);
	}
	
	/**
	 * @return
	 */
	public AbstractAction getMouseClickAction() {
		return ActionRegistrar.getInstance().getAction(mouseClickID);
	}
	
	/**
	 * @return
	 */
	public AbstractAction getMouseReleaseAction() {
		return ActionRegistrar.getInstance().getAction(mouseReleaseID);
	}
	
	/**
	 * @return
	 */
	public AbstractAction getEnterAction() {
		return ActionRegistrar.getInstance().getAction(enterID);
	}
}
