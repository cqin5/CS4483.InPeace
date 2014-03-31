package com.inpeace.characterfilter;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   31 Mar 2014
 */
public class UsernameCharacterFilter implements AbstractCharacterFilter {

	/* (non-Javadoc)
	 * @see com.inpeace.characterfilter.AbstractCharacterFilter#filter(java.awt.event.KeyEvent)
	 */
	@Override
	public boolean filter(char c) {

		if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') 
				|| (c >= 'A' && c <= 'Z')) {
			return true;
		}
		else if (c == '_' || c == '-' || c == '@' || c == '#' || c == '$') {
			return true;
		}
		return false;
	}

}
