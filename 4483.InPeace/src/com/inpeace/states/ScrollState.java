package com.inpeace.states;

import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   19 Mar 2014
 */
public class ScrollState extends AbstractState {

	/**   */
	private ArrayList<String> lines;

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#isHistorical()
	 */
	@Override
	public boolean isHistorical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.states.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get the lines
	 *
	 * @return the lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}

	/**
	 * Set the lines
	 *
	 * @param lines the lines to set
	 */
	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}
	
}
