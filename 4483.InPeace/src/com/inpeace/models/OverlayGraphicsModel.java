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
 * @since   18 Mar 2014
 */
public class OverlayGraphicsModel extends AbstractModel {

	/**   */
	private String spriteCode;

	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;

	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayGraphicsModel() {
		spriteCode = "";
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
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
	 * @throws IncompatibleObjectException
	 */
	public void setOverlayObjectEntity(AbstractEntityGraphic entity)
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
	public void clearOverlayObjectEntity(Integer depth) {
		if (objects.containsKey(depth)) {
			objects.remove(depth);
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * @param graphic
	 * @param depth
	 */
	private void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		objects.put(depth, graphic);
		fireChange(GraphicsController.OVERLAY_OBJECTS, 
				new ArrayList<AbstractEntityGraphic>(objects.values()));
	}

	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	private void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		if (objects.get(depth).update(graphic)) {
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntityGraphic>(objects.values()));
		}
	}

	/**
	 * 
	 */
	public void clearOverlayObjects() {
		if (objects != null) {
			objects.clear();
			fireChange(GraphicsController.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntityGraphic>());
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(GraphicsController.OVERLAY_GRAPHIC_SPRITE_CODE, spriteCode);
		fireChange(GraphicsController.OVERLAY_OBJECTS, 
				new ArrayList<AbstractEntityGraphic>());
	}

}

