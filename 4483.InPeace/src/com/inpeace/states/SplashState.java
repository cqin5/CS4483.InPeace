package com.inpeace.states;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   20 Mar 2014
 */
public class SplashState extends AbstractState {
	
	/** Seconds to display the splash  */
	private int duration;
	
	/**   */
	private String graphicPath;

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.gui.general.GUIDelegate#close()
	 */
	@Override
	public void close() {
		//NULL BODY
		//No action to be performed
		
	}

	/**
	 * Get the duration
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Set the duration
	 *
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Get the graphicPath
	 *
	 * @return the graphicPath
	 */
	public String getGraphicPath() {
		return graphicPath;
	}

	/**
	 * Set the graphicPath
	 *
	 * @param graphicPath the graphicPath to set
	 */
	public void setGraphicPath(String graphicPath) {
		this.graphicPath = graphicPath;
	}

}
