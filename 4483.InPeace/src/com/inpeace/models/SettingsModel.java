package com.inpeace.models;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class SettingsModel extends AbstractModel {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = -2127714796260188343L;
	
	/**   */
	private float musicVolume;
	
	/**   */
	private float soundEffectsVolume;
	
	private float brightness;
	
	private long hintDelay;
	
	

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		// TODO Auto-generated method stub
		
	}

}
