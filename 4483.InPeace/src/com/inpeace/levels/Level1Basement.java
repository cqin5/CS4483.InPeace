package com.inpeace.levels;

import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractEntityAction;
import com.inpeace.actions.ChangeStateAction;
import com.inpeace.actions.MoveEntityAction;
import com.inpeace.entities.ImageEntity;
import com.inpeace.exceptions.EntityException;
import com.inpeace.graphics.SpriteCode;


/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   28 Mar 2014
 */
public class Level1Basement extends Level {

	/**   */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.inpeace.data.Level#construct()
	 */
	@Override
	public void construct() {
		// TODO Auto-generated method stub
		
		/* NOTE: These entities need to have added
		 * 
		 * 1. Accurate positions
		 * 
		 * 2. Proper actions
		 *    a. Multiple, context dependent actions (drop down menu)
		 *    b. Proper type of actions
		 * 
		 * 3. Correct depths and images
		 */
		
		// Create LANTERNS
		
		// only have one created so far
		
		ImageEntity lantern1 = null;
		SpriteCode lanternSprite = null;
		MoveEntityAction pushLeft = new MoveEntityAction(lantern1, new Point(200, 100), new Rectangle(20, 80));
		try {
			lantern1 = new ImageEntity(2, pushLeft, 'l', lanternSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create SHELF
		
		ImageEntity shelf = null;
		SpriteCode shelfSprite = null;
		ChangeStateAction shelfBreak = null;
		try {
			shelf = new ImageEntity(2, shelfBreak, 's', shelfSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Create ROCKS
		
		ImageEntity rock = null;
		SpriteCode rockSprite = null;
		MoveEntityAction throwRock = null;
		try {
			rock = new ImageEntity(3, shelfBreak, 'r', rockSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Create DOOR
		
		ImageEntity door = null;
		SpriteCode doorSprite = null;
		MoveEntityAction openDoor = null;
		try {
			door = new ImageEntity(2, openDoor, 'd', doorSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Create CORPSE
		
		ImageEntity corpse = null;
		SpriteCode corpseSprite = null;
		AbstractEntityAction displayText = null;
		try {
			corpse = new ImageEntity(2, displayText, 'd', corpseSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.levels.Level#load()
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
