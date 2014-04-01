package com.inpeace.actions;

import com.inpeace.entities.AbstractImageEntity;
import com.inpeace.exceptions.EntityException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class CycleImageAction extends AbstractEntityAction {

	/**   */
	private static final long serialVersionUID = 1683425432120377758L;

	/**
	 * Constructs a new CycleImageAction object.
	 *
	 * @param entity
	 */
	public CycleImageAction(AbstractImageEntity entity) {
		super(entity);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.engine.LogicElement#execute()
	 */
	@Override
	public void execute() {
		int currentVersion = ((AbstractImageEntity) getEntity()).getCurrentVersion();
		try {
			((AbstractImageEntity) getEntity()).setCurrentVersion(currentVersion);
		} catch (EntityException e) {
			try {
				((AbstractImageEntity) getEntity()).setCurrentVersion(0);
			} catch (EntityException e1) {
				//NULL BODY
			}
		}		
	}
}
