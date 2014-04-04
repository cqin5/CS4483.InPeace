package com.inpeace.levels;

import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.AbstractEntityAction;
import com.inpeace.actions.BooleanFalseAction;
import com.inpeace.actions.BooleanTrueAction;
import com.inpeace.actions.ChangeStateAction;
import com.inpeace.actions.ConditionalAction;
import com.inpeace.actions.MoveEntityAction;
import com.inpeace.actions.MultiAction;
import com.inpeace.actions.TextAction;
import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.entities.ImageEntity;
import com.inpeace.entities.TextEntity;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.SpriteCodeException;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.models.DefaultGraphicsModel;


/**
 * @author  James Anderson, Taylor Calder
 * @version 0.1
 * @since   28 Mar 2014
 */
public class Level1Basement extends Level {

	/**   */
	private static final long serialVersionUID = 1L;
	
	/**   */
	DefaultGraphicsModel model;
	
	/* (non-Javadoc)
	 * @see com.inpeace.data.Level#construct()
	 */
	@Override
	public void construct() {
		
		// whether the lantern is in the left position
		boolean left = false;
		
		// whether the shelf has been weakened
		boolean weaken = false;
		
		// whether the shelf has fallen
		boolean fallen = false;
		
		
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
		
		int lanternX = 200;
		
		TextEntity lanternDescription = new TextEntity(1, new Point(lanternX, 200), "An old lantern. Looks heavy.");
		//lanternDescription.setFontSize((float) 0);
		TextAction lanternText = new TextAction(lanternDescription);
		
		ImageEntity lantern = null;
		SpriteCode lanternSprite = null;
		
		// create lantern
		
		try {
			lantern = new ImageEntity(1, lanternText, 'l', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(200, 100));
		} catch (EntityException | SpriteCodeException e1) {
			e1.printStackTrace();
		}
		
		
		
		BooleanFalseAction lanternPositionRight = new BooleanFalseAction(left);
		BooleanTrueAction lanternPositionLeft = new BooleanTrueAction(left);
		
		
		//MultiAction 
		
		//ConditionalAction lanternIsLeft = new ConditionalAction(lantern)
		
		MoveEntityAction pushLeft = new MoveEntityAction(lantern, new Point(-50, 0), new Rectangle(0, 0));
		MoveEntityAction pushRight = new MoveEntityAction(lantern, new Point(50, 0), new Rectangle(0, 0));
		MoveEntityAction moveUp = new MoveEntityAction(lantern, new Point(0, -100), new Rectangle(70, 800));
		MoveEntityAction moveDown = new MoveEntityAction(lantern, new Point(0, 100), new Rectangle(70, 800));
		
		// lantern moves left
		MultiAction lanternLeft = new MultiAction(pushLeft, lanternPositionLeft);
		
		// lantern moves 
		MultiAction lanternRight = new MultiAction(pushRight, lanternPositionRight);
		
		MultiAction lanternLevitate = new MultiAction(moveUp, moveDown);
		
		// move lantern left button
		ImageEntity lanternL = null;
		
		// move lantern right button
		ImageEntity lanternR = null; 
		
		// levitate lantern button
		ImageEntity lanternLev = null; 
		
		try {
			lanternL = new ImageEntity(2, lanternLeft, 'l', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(100, 400));
		} catch (EntityException | SpriteCodeException e1) {
			e1.printStackTrace();
		}
		
		try {
			lanternR = new ImageEntity(3, lanternRight, 'l', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(300, 400));
		} catch (EntityException | SpriteCodeException e1) {
			e1.printStackTrace();
		}
		
		try {
			lanternLev = new ImageEntity(10, lanternLevitate, 'l', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(200, 400));
		} catch (EntityException | SpriteCodeException e1) {
			e1.printStackTrace();
		}

		
		// Create SHELF
		
		TextEntity shelfDescription = new TextEntity(4, new Point(600, 300), "The left support looks weak.");
		//shelfDescription.setFontSize((float) 0);
		TextAction shelfText = new TextAction(shelfDescription);
		
		ImageEntity shelf = null;
		SpriteCode shelfSprite = null;

		try {
			shelf = new ImageEntity(2, shelfText, 's', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(600, 200));
		} catch (EntityException | SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Create ROCKS
		
		TextEntity rockDescription = new TextEntity(5, new Point(200, 200), "A pile of rocks. I could probably throw them.");
		//rockDescription.setFontSize((float) 0);
		TextAction rockText = new TextAction(rockDescription);
		
		/* Still working on how to do the rock throwing
		 * 
		 * I'm thinking a MixedAction that involves 
		 */
		
		ImageEntity throwRockDoor = null;
		ImageEntity throwRockShelf = null;
		ImageEntity throwRockLantern = null;
		
		ImageEntity rock = null;
		SpriteCode rockSprite = null;
		try {
			rock = new ImageEntity(3, rockText, 'r', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(300, 500));
		} catch (EntityException | SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Create DOOR
		
		TextEntity doorDescription = new TextEntity(6, new Point(25, 200), "It's barred from the other side.");
		//doorDescription.setFontSize((float) 0);
		TextAction doorText = new TextAction(doorDescription);
		
		ImageEntity door = null;
		SpriteCode doorSprite = null;

		try {
			door = new ImageEntity(7, doorText, 'd', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(100, 100));
		} catch (EntityException | SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Create CORPSE

		TextEntity corpseDescription = new TextEntity(8, new Point(200, 200), "Is this...me?");
		//corpseDescription.setFontSize((float) 0);
		TextAction corpseText = new TextAction(corpseDescription);
		
		ImageEntity corpse = null;
		SpriteCode corpseSprite = null;

		try {
			corpse = new ImageEntity(9, corpseText, 'd', SpriteCode.get("1-0-0-128-128-4-4"), true, true, new Point(100, 100));
		} catch (EntityException | SpriteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/**
		 * Add entities to foreground
		 */
		
		model = new DefaultGraphicsModel();
		
		model.setForegroundObjectEntity(lantern);
		//model.setForegroundObjectEntity(lanternDescription);
		
		//model.setForegroundObjectEntity(shelf);
		//model.setForegroundObjectEntity(shelfDescription);
		
		//model.setForegroundObjectEntity(rock);
		//model.setForegroundObjectEntity(rockDescription);
		
		//model.setForegroundObjectEntity(door);
		//model.setForegroundObjectEntity(doorDescription);
		
		model.setForegroundObjectEntity(lanternR);
		model.setForegroundObjectEntity(lanternL);
		
		MailRoom.getInstance().postRequest(PropertyName.DEFAULT_GRAPHICS_MODEL, model,
				RequestType.REGISTER);
		
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.levels.Level#load()
	 */
	@Override
	public void load() {
		
		
		MailRoom.getInstance().postRequest(PropertyName.DEFAULT_GRAPHICS_MODEL, model,
				RequestType.REGISTER);
		model.setBackgroundName("test");
		
	}

}
