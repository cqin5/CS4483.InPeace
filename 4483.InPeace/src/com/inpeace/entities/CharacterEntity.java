package com.inpeace.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

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
	private final String defaultSpriteCode;
	
	/**   */
	private int versionCount;
	
	/**   */
	private int currentVersion;
	
	/**   */
	private BufferedImage[][] images;
	
	/**   */
	private boolean canRun;
	
	/**   */
	private boolean walking;
	private boolean running;

	/**
	 * Constructs a new CharacterEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param enterAction
	 * @param position
	 */
	public CharacterEntity(int depth, Point position, String defaultSpriteCode, int versionCount, 
			boolean canRun) {
		super(depth, null, null, position);
		this.defaultSpriteCode = defaultSpriteCode;
		currentVersion = 0;
		int lines = 3;
		if (canRun) {
			lines = 5;
		}
		this.images = new BufferedImage[lines][currentVersion];
		
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
				
			}
			else {
				
			}
		}
		else {
			throw new EntityException("Character can not run");
		}
	}

}
