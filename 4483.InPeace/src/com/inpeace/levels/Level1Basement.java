package com.inpeace.levels;

import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractEntityAction;
import com.inpeace.actions.BooleanFalseAction;
import com.inpeace.actions.BooleanTrueAction;
import com.inpeace.actions.ChangeStateAction;
import com.inpeace.actions.MoveEntityAction;
import com.inpeace.actions.MultiAction;
import com.inpeace.actions.TextAction;
import com.inpeace.entities.ImageEntity;
import com.inpeace.entities.TextEntity;
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
	private ImageEntity[] leftShelf = new ImageEntity[4];
	private ImageEntity[] rightShelf = new ImageEntity[4];

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
		
		// Create LANTERN
		
		// NOTE: To make this easier I'm only having one lantern
		
		// descriptive text for lantern
		
		TextEntity lanternDescription = new TextEntity(1, new Point(200, 200), "An old lantern. Looks heavy.");
		lanternDescription.setFontSize((float) 0);
		TextAction lanternText = new TextAction(lanternDescription);
		
		ImageEntity lantern = null;
		SpriteCode lanternSprite = null;
		
		// create lantern
		
		try {
			lantern = new ImageEntity(2, lanternText, 'l', lanternSprite, true, true, new Point(100, 100));
		} catch (EntityException e1) {
			e1.printStackTrace();
		}
		
		boolean right = true;
		
		BooleanTrueAction lanternPositionRight = new BooleanTrueAction(right);
		BooleanFalseAction lanternPositionLeft = new BooleanFalseAction(right);
		
		MoveEntityAction pushLeft = new MoveEntityAction(lantern, new Point(200, 100), new Rectangle(20, 80));
		MoveEntityAction pushRight = new MoveEntityAction(lantern, new Point(200, 300), new Rectangle(20, 80));
		
		MultiAction lanternLeft = new MultiAction(pushLeft, lanternPositionLeft);
		MultiAction lanternRight = new MultiAction(pushRight, lanternPositionRight);

		
		// Create SHELF
		
		TextEntity shelfDescription = new TextEntity(1, new Point(200, 200), "The left support looks weak.");
		lanternDescription.setFontSize((float) 0);
		TextAction shelfText = new TextAction(shelfDescription);
		
		ImageEntity shelf = null;
		SpriteCode shelfSprite = null;

		try {
			shelf = new ImageEntity(2, shelfText, 's', shelfSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Create ROCKS
		
		TextEntity rockDescription = new TextEntity(1, new Point(200, 200), "A pile of rocks. I could probably throw them.");
		lanternDescription.setFontSize((float) 0);
		TextAction rockText = new TextAction(rockDescription);
		
		ImageEntity rock = null;
		SpriteCode rockSprite = null;
		try {
			rock = new ImageEntity(3, rockText, 'r', rockSprite, true, true, new Point(100, 100));
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
