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
import com.inpeace.controllers.PropertyName;
import com.inpeace.engine.MailRoom;
import com.inpeace.engine.Request.RequestType;
import com.inpeace.entities.ImageEntity;
import com.inpeace.entities.TextEntity;
import com.inpeace.exceptions.EntityException;
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
		
		ImageEntity lanternL = null;
		ImageEntity lanternR = null; 
		
		try {
			lanternL = new ImageEntity(2, pushLeft, 'l', lanternSprite, true, true, new Point(100, 100));
		} catch (EntityException e1) {
			e1.printStackTrace();
		}
		
		try {
			lanternR = new ImageEntity(3, pushRight, 'l', lanternSprite, true, true, new Point(100, 100));
		} catch (EntityException e1) {
			e1.printStackTrace();
		}

		
		// Create SHELF
		
		TextEntity shelfDescription = new TextEntity(4, new Point(200, 200), "The left support looks weak.");
		shelfDescription.setFontSize((float) 0);
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
		
		TextEntity rockDescription = new TextEntity(5, new Point(200, 200), "A pile of rocks. I could probably throw them.");
		rockDescription.setFontSize((float) 0);
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
		
		TextEntity doorDescription = new TextEntity(6, new Point(200, 200), "It's barred from the other side.");
		doorDescription.setFontSize((float) 0);
		TextAction doorText = new TextAction(doorDescription);
		
		ImageEntity door = null;
		SpriteCode doorSprite = null;

		try {
			door = new ImageEntity(7, doorText, 'd', doorSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Create CORPSE

		TextEntity corpseDescription = new TextEntity(8, new Point(200, 200), "Is this...me?");
		corpseDescription.setFontSize((float) 0);
		TextAction corpseText = new TextAction(corpseDescription);
		
		ImageEntity corpse = null;
		SpriteCode corpseSprite = null;

		try {
			corpse = new ImageEntity(9, corpseText, 'd', corpseSprite, true, true, new Point(100, 100));
		} catch (EntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model = new DefaultGraphicsModel();
		
		model.setForegroundObjectEntity(lantern);
		model.setForegroundObjectEntity(lanternDescription);
		
		model.setForegroundObjectEntity(shelf);
		model.setForegroundObjectEntity(shelfDescription);
		
		model.setForegroundObjectEntity(rock);
		model.setForegroundObjectEntity(rockDescription);
		
		model.setForegroundObjectEntity(door);
		model.setForegroundObjectEntity(doorDescription);
		
		model.setForegroundObjectEntity(lanternR);
		model.setForegroundObjectEntity(lanternL);
		
		
	}

	/* (non-Javadoc)
	 * @see com.inpeace.levels.Level#load()
	 */
	@Override
	public void load() {
		
		
		MailRoom.getInstance().postRequest(PropertyName.DEFAULT_GRAPHICS_MODEL, model,
				RequestType.REGISTER);
		
	}

}
