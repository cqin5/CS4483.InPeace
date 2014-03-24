package com.inpeace.data;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   24 Mar 2014
 */
public class SettingsService {

	private static SettingsService instance = null;
	
	/**   */
	private Settings settings;

	private SettingsService() {
		//NULL BODY
	}
	
	public static SettingsService getInstance() {
		if (instance == null) {
			instance = new SettingsService();
		}
		return instance;
	}
	
}
