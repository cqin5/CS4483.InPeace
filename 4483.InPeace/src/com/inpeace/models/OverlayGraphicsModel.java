package com.inpeace.models;

import java.util.ArrayList;
import java.util.TreeMap;

import com.inpeace.controllers.GraphicsController;
import com.inpeace.entities.AbstractEntity;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   18 Mar 2014
 */
public class OverlayGraphicsModel extends AbstractModel {

	/**   */
	private String spriteCode;

	/**   */
	private TreeMap<Integer, AbstractEntity> objects;

	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayGraphicsModel() {
		spriteCode = "";
		objects = new TreeMap<Integer, AbstractEntity>();
	}

	/**
	 * @return
	 */
	public String getOverlaySpriteCode() {
		return spriteCode;
	}

	/**
	 * @param spriteCode
	 */
	public void setOverlaySpriteCode(String spriteCode) {
		if (this.spriteCode != spriteCode) {
			this.spriteCode = spriteCode;
			fireChange(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, spriteCode);
		}
	}

	/**
	 * 
	 */
	public void clearOverlaySpriteCode() {
		setOverlaySpriteCode("");
	}

	/**
	 * @param entity
	 */
	public void setOverlayObjectEntity(AbstractEntity entity) {
		objects.put(entity.getDepth(), entity);
		fireChange(GraphicsController.OVERLAY_OBJECTS, 
				new ArrayList<AbstractEntity>(objects.values()));
	}

	/**
	 * @param depth
	 */
	public void clearOverlayObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			objects.remove(depth);
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearOverlayObjects() {
		if (objects != null) {
			objects.clear();
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, spriteCode);
		if (objects != null || !objects.isEmpty()) {
			fireChange(GraphicsController.OVERLAY_OBJECT_ENTITY, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
		else {
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
	}

}

