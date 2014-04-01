package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.inpeace.GameProperties;
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
	private long imageChange;

	/**   */
	private int motionState;

	/**   */
	private boolean canRun;

	/**   */
	private Rectangle confines;

	/**   */
	private int speed;

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
		this.imageChange = 0;
		this.speed = 0;
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
			this.speed = speed;
			if (speed < 0) {
				motionState = 4;
			}
			else {
				motionState = 3;
			}
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
		this.speed = speed;
		if (speed < 0) {
			motionState = 2;
		}
		else {
			motionState = 1;
		}
	}

	/**
	 * 
	 */
	public void stop() {
		motionState = 0;
		speed = 0;
	}

	/* (non-Javadoc)
	 * @see com.inpeace.entities.AbstractEntity#paint(java.awt.Graphics2D, int, java.awt.Point, boolean)
	 */
	@Override
	public void paint(Graphics2D g, int scrollPosition, Point mousePosition,
			boolean active) throws ResourceAccessException {

		if (imageChange <= System.currentTimeMillis()) {
			try {
				setCurrentVersion(getCurrentVersion() + 1);
			} catch (EntityException e) {
				try {
					setCurrentVersion(0);
				} catch (EntityException e1) {
					//NULL BODY
				}
			}

			if (motionState == 0) {
				imageChange = System.currentTimeMillis() + (long)(idleSpeed * 1000);
			}
			else {
				imageChange = System.currentTimeMillis() + (long)(animationSpeed * 1000);
			}
		}
		Point newPosition = new Point(getPosition().x + speed, getPosition().y);
		if (confines.contains(newPosition)) {
			setPosition(newPosition);
		}
		
		int x = getPosition().x - scrollPosition;
		int y = getPosition().y;
		int width = getSpriteCode().width;
		int cutx = 0;
		int height = getSpriteCode().height;
		int cuty = 0;

		if (x < (GameProperties.DEFAULT_WIDTH + width) && x > (0 - width) 
				&& y < (GameProperties.DEFAULT_HEIGHT + height) && y > (0 - height)) {	

			if ((x + width) > GameProperties.DEFAULT_WIDTH) {
				width = GameProperties.DEFAULT_WIDTH - x;
			}
			else if (x < 0) {
				cutx = -x;
				width -= cutx;
			}
			
			if ((y + height) > GameProperties.DEFAULT_HEIGHT) {
				height = GameProperties.DEFAULT_HEIGHT - y;
			}
			else if (y < 0) {
				cuty = -y;
				height -= cuty;
			}
			
			g.drawImage(getImage(motionState, getCurrentVersion()).getSubimage(cutx, 0, width, height),
					x + cutx, y + cuty, null);
		}
	}

}
