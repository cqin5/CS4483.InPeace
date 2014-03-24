package com.inpeace.states;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class MainMenuState extends AbstractState {

	/**   */
	private final String backgroundName;
	
	/**   */
	private Long[] buttonSpriteCodes;

	/**
	 * Get the buttonSpriteCodes
	 *
	 * @return the buttonSpriteCodes
	 */
	public Long[] getButtonSpriteCodes() {
		return buttonSpriteCodes;
	}

	/**
	 * Set the buttonSpriteCodes
	 *
	 * @param buttonSpriteCodes the buttonSpriteCodes to set
	 */
	public void setButtonSpriteCodes(Long[] buttonSpriteCodes) {
		this.buttonSpriteCodes = buttonSpriteCodes;
	}

	/**
	 * Get the backgroundName
	 *
	 * @return the backgroundName
	 */
	public String getBackgroundName() {
		return backgroundName;
	}

	/**
	 * Constructs a new MainMenuState object.
	 *
	 */
	public MainMenuState() {
		backgroundName = "main";
		buttonSpriteCodes[0] = (long) 1;
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}
