package com.inpeace.models;

import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.exceptions.IncompatibleObjectException;
import com.inpeace.graphics.AbstractEntityGraphic;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class HUDModel extends AbstractModel {
	
	/**   */
	private String spriteCode;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public HUDModel() {
		spriteCode = "";
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * @return
	 */
	public String getHUDSpriteCode() {
		return spriteCode;
	}

	/**
	 * @param spriteCode
	 */
	public void setHUDSpriteCode(String spriteCode) {
		if (this.spriteCode != spriteCode) {
			String old = this.spriteCode;
			this.spriteCode = spriteCode;
			fireChange(GraphicsController.HUD_GRAPHIC_SPRITE_CODE, old, spriteCode);
		}
	}

	/**
	 * 
	 */
	public void clearHUDSpriteCode() {
		setHUDSpriteCode("");
	}

	/**
	 * @param entity
	 * @throws IncompatibleObjectException
	 */
	public void setHUDObjectEntity(AbstractEntityGraphic entity)
			throws IncompatibleObjectException {
		if (!objects.containsKey(entity.getDepth())) {
			addObjectEntity(entity, entity.getDepth());
		}
		else {
			updateObjectEntity(entity, entity.getDepth());		
		}
	}
	
	/**
	 * @param depth
	 */
	public void clearHUDObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			ArrayList<AbstractEntityGraphic> old = 
					new ArrayList<AbstractEntityGraphic>(objects.values());
			objects.remove(depth);
			fireChange(GraphicsController.HUD_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * @param graphic
	 * @param depth
	 */
	private void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		ArrayList<AbstractEntityGraphic> old = 
				new ArrayList<AbstractEntityGraphic>(objects.values());
		objects.put(depth, graphic);
		fireChange(GraphicsController.HUD_OBJECTS, old, 
				new ArrayList<AbstractEntityGraphic>(objects.values()));
	}

	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		ArrayList<AbstractEntityGraphic> old = 
				new ArrayList<AbstractEntityGraphic>(objects.values());
		if (objects.get(depth).update(graphic)) {
			fireChange(GraphicsController.HUD_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearHUDObjects() {
		if (objects != null) {
			ArrayList<AbstractEntityGraphic> old = 
					new ArrayList<AbstractEntityGraphic>(objects.values());
			objects.clear();
			fireChange(GraphicsController.HUD_OBJECTS, old, 
					new ArrayList<AbstractEntityGraphic>());
		}
	}
	
}
