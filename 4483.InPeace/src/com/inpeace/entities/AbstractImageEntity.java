package com.inpeace.entities;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.inpeace.actions.AbstractAction;
import com.inpeace.exceptions.EntityException;
import com.inpeace.exceptions.ResourceAccessException;
import com.inpeace.graphics.SpriteCode;
import com.inpeace.library.Librarian;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   29 Mar 2014
 */
public abstract class AbstractImageEntity extends AbstractEntity {

	/**   */
	private final SpriteCode spriteCode;

	/**   */
	private final BufferedImage[][] images;
	
	/**   */
	private int currentVersion;
	private int currentSet;
	
	/**
	 * Constructs a new AbstractImageEntity object.
	 *
	 * @param depth
	 * @param pressAction
	 * @param defaultSpriteCode
	 * @param versionCount
	 * @param imageSets
	 * @param position
	 */
	public AbstractImageEntity(int depth, AbstractAction pressAction,
			SpriteCode spriteCode, Point position) {
		
		super(depth, pressAction, null, new Rectangle(position, 
				spriteCode.getDimensions()));
		
		this.spriteCode = spriteCode;
		this.images = new BufferedImage[spriteCode.sets][spriteCode.versions];
		this.currentVersion = 0;
		this.currentSet = 0;
	}

	/**
	 * Get the currentVersion
	 *
	 * @return the currentVersion
	 */
	public int getCurrentVersion() {
		return currentVersion;
	}

	/**
	 * Set the currentVersion
	 *
	 * @param currentVersion the currentVersion to set
	 * @throws EntityException 
	 */
	public void setCurrentVersion(int currentVersion) throws EntityException {
		if (currentVersion < 0 || currentVersion > spriteCode.versions) {
			throw new EntityException("Unable to set image version to " + currentVersion + ", the version"
					+ " must be between 0 and " + spriteCode.versions + " (ImageEntity)");
		}
		this.currentVersion = currentVersion;
	}

	/**
	 * Get the currentSet
	 *
	 * @return the currentSet
	 */
	public int getCurrentSet() {
		return currentSet;
	}

	/**
	 * Set the currentSet
	 *
	 * @param currentSet the currentSet to set
	 */
	public void setCurrentSet(int currentSet) {
		this.currentSet = currentSet;
	}

	/**
	 * Get the spriteCode
	 *
	 * @return the spriteCode
	 */
	public SpriteCode getSpriteCode() {
		return spriteCode;
	}
	
	/**
	 * @param set
	 * @param version
	 * @return
	 * @throws ResourceAccessException 
	 */
	public BufferedImage getImage(int set, int version) throws ResourceAccessException {
		if (images[set][version] == null) {
			images[set][version] = 
					Librarian.getInstance().getSprite(spriteCode.convertCode(set, version));
		}
		return images[set][version];
	}

}
