package com.inpeace.levels;


/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class LevelFactory {

	public static Level buildLevel(int levelNum) {

		switch (levelNum) {
		case 1:
			return new Level1Basement();
			//TODO: add any subsequent cases
		}
		return null;
	}
	
}
