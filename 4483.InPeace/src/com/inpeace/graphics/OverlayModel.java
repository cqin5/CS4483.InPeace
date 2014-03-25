package com.inpeace.graphics;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   18 Mar 2014
 */
public class OverlayModel extends AbstractModel {

	/**   */
	private long spriteCode;
	
	/**   */
	private TreeMap<Integer, AbstractEntityGraphic> objects;
	
	/**
	 * Constructs a new OverlayModel object.
	 *
	 */
	public OverlayModel() {
		spriteCode = 0;
		objects = new TreeMap<Integer, AbstractEntityGraphic>();
	}
	
	/**
	 * @return
	 */
	public long getOverlaySpriteCode() {
		return spriteCode;
	}

	/**
	 * @param name
	 */
	public void setBackground(long name) {
		if (this.spriteCode != name) {
			long old = this.spriteCode;
			this.spriteCode = name;
			fireChange("OverlaySpriteCode", old, name);
		}
	}
	
	/**
	 * @param graphic
	 * @param depth
	 */
	public void addObjectEntity(AbstractEntityGraphic graphic, int depth) {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		objects.put(depth, graphic);
		fireChange("ObjectIterator", old, getObjectIterator());
	}
	
	/**
	 * @param graphic
	 * @param depth
	 * @throws IncompatibleObjectException 
	 */
	public void updateObjectEntity(AbstractEntityGraphic graphic, int depth)
			throws IncompatibleObjectException {
		Iterator<Entry<Integer, AbstractEntityGraphic>> old = getObjectIterator();
		if (objects.get(depth).update(graphic)) {
			fireChange("ObjectIterator", old, getObjectIterator());
		}
	}
	
	/**
	 * @return
	 */
	public Iterator<Entry<Integer, AbstractEntityGraphic>> getObjectIterator() {
		return objects.entrySet().iterator();
	}
	
}

