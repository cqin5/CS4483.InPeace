package com.inpeace.engine;

import java.util.HashMap;

import com.inpeace.actions.AbstractAction;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class ActionRegistrar {
	
	/**   */
	private static ActionRegistrar instance;
	
	/**   */
	private Integer lastAssignedID;
	
	/**   */
	private HashMap<Integer, AbstractAction> registry;
	
	/**
	 * Constructs a new ActionRegistrar object.
	 *
	 */
	private ActionRegistrar() {
		lastAssignedID = 0;
		registry = new HashMap<Integer, AbstractAction>();
	}
	
	/**
	 * @return
	 */
	public static ActionRegistrar getInstance() {
		if (instance == null) {
			instance = new ActionRegistrar();
		}
		return instance;
	}
	
	/**
	 * @param action
	 * @return
	 */
	public Integer registerAction(AbstractAction action) {
		action.setActionID(++lastAssignedID);
		registry.put(lastAssignedID, action);
		return lastAssignedID;
	}
	
	/**
	 * @param actionID
	 * @return
	 */
	public AbstractAction getAction(Integer actionID) {
		return registry.get(actionID);
	}
	
	/**
	 * @param actionID
	 * @return
	 */
	public AbstractAction removeAction(Integer actionID) {
		return registry.remove(actionID);
	}

}
