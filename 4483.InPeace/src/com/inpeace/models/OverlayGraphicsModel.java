package com.inpeace.models;

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
 * @since   18 Mar 2014
 */
public class OverlayGraphicsModel extends AbstractModel {

	/**   */
	private static final long serialVersionUID = 2366740043176152479L;

	/**   */
	private SpriteCode spriteCode;

	/**   */
	private TreeMap<Integer, AbstractEntity> objects;

	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayGraphicsModel() {
		super();
		spriteCode = null;
		objects = new TreeMap<Integer, AbstractEntity>();
	}

	/**
	 * @param spriteCode
	 */
	public void setOverlaySpriteCode(SpriteCode spriteCode) {
		if (this.spriteCode != spriteCode) {
			this.spriteCode = spriteCode;
			fireChange(PropertyName.OVERLAY_GRAPHIC_SPRITE_CODE, spriteCode);
		}
	}

	/**
	 * @param entity
	 */
	public void setOverlayObjectEntity(AbstractEntity entity) {
		if (entity.getClass().equals(NullEntity.class)) {
			objects.remove(entity.getDepth());
		}
		else {
			objects.put(entity.getDepth(), entity);
			fireChange(PropertyName.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

	/* (non-Javadoc)
	 * @see com.inpeace.models.AbstractModel#fireAll()
	 */
	@Override
	public void fireAll() {
		fireChange(PropertyName.OVERLAY_GRAPHIC_SPRITE_CODE, spriteCode);
		if (objects == null || objects.isEmpty()) {
			fireChange(PropertyName.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>());
		}
		else {
			fireChange(PropertyName.OVERLAY_OBJECTS, 
					new ArrayList<AbstractEntity>(objects.values()));
		}
	}

}

