package com.inpeace.models;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.PropertyName;
import com.inpeace.entities.AbstractEntity;
import com.inpeace.entities.NullEntity;
import com.inpeace.graphics.SpriteCode;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class HUDGraphicsModel extends AbstractModel {

	/**   */
	private static final long serialVersionUID = 1226733423590414874L;

	/**   */
	private SpriteCode spriteCode;

	/**   */
	private TreeMap<Integer, AbstractEntity> objects;

	/**   */
	private ArrayList<Rectangle> screenCoverage;

	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public HUDGraphicsModel() {
		super();
		spriteCode = null;
		objects = new TreeMap<Integer, AbstractEntity>();
		screenCoverage = new ArrayList<Rectangle>();
	}

	/**
	 * @param spriteCode
	 */
	public void setHUDSpriteCode(SpriteCode spriteCode) {
		if (this.spriteCode != spriteCode) {
			this.spriteCode = spriteCode;
			fireChange(PropertyName.HUD_GRAPHIC_SPRITE_CODE, spriteCode);
		}
	}

	/**
	 * Set the screenCoverage
	 *
	 * @param screenCoverage the screenCoverage to set
	 */
	public void setHUDScreenCoverage(ArrayList<Rectangle> screenCoverage) {
		this.screenCoverage = screenCoverage;
		fireChange(PropertyName.HUD_SCREEN_COVERAGE, this.screenCoverage);
	}

	/**
	 * @param entity
	 */
	public void setHUDObjectEntity(AbstractEntity entity) {
		if (entity.getClass().equals(NullEntity.class)) {
			objects.remove(entity.getDepth());
		}
		else {
			objects.put(entity.getDepth(), entity);
			fireChange(PropertyName.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(PropertyName.HUD_GRAPHIC_SPRITE_CODE, spriteCode);
		if (objects == null || objects.isEmpty()) {
			fireChange(PropertyName.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
		else {
			fireChange(PropertyName.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

}
