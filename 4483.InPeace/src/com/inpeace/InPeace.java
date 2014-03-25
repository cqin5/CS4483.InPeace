package com.inpeace;

import com.inpeace.engine.GameEngine;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class InPeace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new GameEngine()).start();
	}
}
