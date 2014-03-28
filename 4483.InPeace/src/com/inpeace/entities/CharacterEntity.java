package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.inpeace.actions.CycleImageAction;
import com.inpeace.engine.Scheduler;
import com.inpeace.events.Event;
import com.inpeace.events.RecurringEvent;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.ResourceAccessException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class CharacterEntity extends AbstractEntity {
	
	/**   */
	private final double animationSpeed = 1f;
	private final double idleSpeed = 1f;
	
	/**   */
	private final String defaultSpriteCode;
	
	/**   */
	private int versionCount;
	
	/**   */
	private int currentVersion;
	private int imageState;
	
	/**   */
	private BufferedImage[][] images;
	
	/**   */
	private boolean canRun;
	
	/**   */
	private int movementEventID;
	
	private Rectangle confines;

	/**
	 * Constructs a new CharacterEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param position
	 */
	public CharacterEntity(int depth, Point position, String defaultSpriteCode, int versionCount, 
			boolean canRun, Rectangle confines) {
		super(depth, null, null, position);
		this.defaultSpriteCode = defaultSpriteCode;
		currentVersion = 0;
		imageState = 0;
		int lines = 3;
		if (canRun) {
			lines = 5;
		}
		this.images = new BufferedImage[lines][currentVersion];
		Event event = new Event();
		movementEventID = Scheduler.getInstance().registerEvent(
				new RecurringEvent(idleSpeed, new CycleImageAction(this)), idleSpeed);
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		// TODO Auto-generated method stub
		
	}
	
	public void run(int speed) throws EntityException {
		if (canRun) {
			if (speed < 0) {
				imageState = 4;
			}
			else {
				imageState = 3;
			}
			Event event = new Event();
			movementEventID = Scheduler.getInstance().registerEvent(
					new RecurringEvent(animationSpeed, new CycleImageAction(this)), animationSpeed);
		}
		else {
			throw new EntityException("Character can not run");
		}
	}
	
	public void walk(int speed) throws EntityException {
		if (canRun) {
			if (speed < 0) {
				imageState = 2;
			}
			else {
				imageState = 1;
			}
			Event event = new Event();
			movementEventID = Scheduler.getInstance().registerEvent(
					new RecurringEvent(animationSpeed, new CycleImageAction(this)), animationSpeed);
		}
		else {
			throw new EntityException("Character can not run");
		}
	}
}
