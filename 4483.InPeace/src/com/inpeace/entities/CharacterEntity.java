package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.actions.CycleImageAction;
import com.inpeace.actions.MoveEntityAction;
import com.inpeace.engine.Scheduler;
import com.inpeace.events.RecurringEvent;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteCode;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class CharacterEntity extends AbstractImageEntity {

	/**   */
	private static final long serialVersionUID = 1397270678712927129L;
	
	/**   */
	private final double animationSpeed = 0.5f;
	private final double idleSpeed = 5f;

	/**   */
	private int motionState;

	/**   */
	private boolean canRun;

	/**   */
	private int movementEventID;

	/**   */
	private Rectangle confines;
	
	/**
	 * Constructs a new CharacterEntity object.
	 *
	 * @param depth
	 * @param spriteCode
	 * @param position
	 * @param canRun
	 * @param movementConfines
	 */
	public CharacterEntity(int depth, SpriteCode spriteCode, Point position, boolean canRun,
			Rectangle movementConfines) {
		
		super(depth, null, (char) 0, spriteCode, position);
		this.canRun = canRun;
		this.confines = movementConfines;
		this.motionState = 0;
		
		movementEventID = Scheduler.getInstance().registerEvent(
				new RecurringEvent(idleSpeed, new CycleImageAction(this)), idleSpeed);
	}

	/**
	 * Get the confines
	 *
	 * @return the confines
	 */
	public Rectangle getConfines() {
		return confines;
	}



	/**
	 * Set the confines
	 *
	 * @param confines the confines to set
	 */
	public void setConfines(Rectangle confines) {
		this.confines = confines;
	}



	/**
	 * Get the animationSpeed
	 *
	 * @return the animationSpeed
	 */
	public double getAnimationSpeed() {
		return animationSpeed;
	}

	/**
	 * Get the idleSpeed
	 *
	 * @return the idleSpeed
	 */
	public double getIdleSpeed() {
		return idleSpeed;
	}

	/**
	 * Get the motionState
	 *
	 * @return the motionState
	 */
	public int getMotionState() {
		return motionState;
	}

	/**
	 * @param speed
	 * @throws EntityException
	 */
	public void run(int speed) throws EntityException {
		if (canRun) {
			if (speed < 0) {
				motionState = 4;
			}
			else {
				motionState = 3;
			}
			Point translation = new Point(speed, 0);
			movementEventID = Scheduler.getInstance().registerEvent(
					new RecurringEvent(animationSpeed, new CycleImageAction(this), 
							new MoveEntityAction(this, translation, confines)), animationSpeed);
		}
		else {
			throw new EntityException("Character can not run");
		}
	}

	/**
	 * @param speed
	 * @throws EntityException
	 */
	public void walk(int speed) throws EntityException {
		if (speed < 0) {
			motionState = 2;
		}
		else {
			motionState = 1;
		}
		Point translation = new Point(speed, 0);
		movementEventID = Scheduler.getInstance().registerEvent(
				new RecurringEvent(animationSpeed, new CycleImageAction(this), 
						new MoveEntityAction(this, translation, confines)), animationSpeed);
	}
	
	/**
	 * 
	 */
	public void stop() {
		Scheduler.getInstance().deregisterEvent(movementEventID);
		motionState = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {
		// TODO Auto-generated method stub

	}
	
}
