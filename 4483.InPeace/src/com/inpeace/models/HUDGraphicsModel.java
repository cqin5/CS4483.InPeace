package com.inpeace.models;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.entities.AbstractEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class HUDGraphicsModel extends AbstractModel {

	/**   */
	private String spriteCode;

	/**   */
	private TreeMap<Integer, AbstractEntity> objects;

	/**   */
	private ArrayList<Rectangle> screenCoverage;

	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public HUDGraphicsModel() {
		spriteCode = "";
		objects = new TreeMap<Integer, AbstractEntity>();
		screenCoverage = new ArrayList<Rectangle>();
	}

	/**
	 * @param spriteCode
	 */
	public void setHUDSpriteCode(String spriteCode) {
		if (this.spriteCode != spriteCode) {
			this.spriteCode = spriteCode;
			fireChange(GraphicsController.HUD_GRAPHIC_SPRITE_CODE, spriteCode);
		}
	}

	/**
	 * 
	 */
	public void clearHUDSpriteCode() {
		setHUDSpriteCode("");
	}

	/**
	 * Set the screenCoverage
	 *
	 * @param screenCoverage the screenCoverage to set
	 */
	public void setHUDScreenCoverage(ArrayList<Rectangle> screenCoverage) {
		this.screenCoverage = screenCoverage;
		fireChange(GraphicsController.HUD_SCREEN_COVERAGE, this.screenCoverage);
	}

	/**
	 * 
	 */
	public void clearHUDScreenCoverage() {
		setHUDScreenCoverage(new ArrayList<Rectangle>());
	}

	/**
	 * @param entity
	 */
	public void setHUDObjectEntity(AbstractEntity entity) {
		objects.put(entity.getDepth(), entity);
		fireChange(GraphicsController.HUD_OBJECTS, 
				new ArrayList<AbstractEntity>(objects.values()));
	}

	/**
	 * @param depth
	 */
	public void clearHUDObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			objects.remove(depth);
			fireChange(GraphicsController.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearHUDObjects() {
		if (objects != null) {
			objects.clear();
			fireChange(GraphicsController.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(GraphicsController.HUD_GRAPHIC_SPRITE_CODE, spriteCode);
		if (objects != null || !objects.isEmpty()) {
			fireChange(GraphicsController.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
		else {
			fireChange(GraphicsController.HUD_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

}
