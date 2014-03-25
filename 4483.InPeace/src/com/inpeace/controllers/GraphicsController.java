package com.inpeace.controllers;

import com.inpeace.states.AbstractState;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   23 Mar 2014
 */
public class GraphicsController extends AbstractController {
	
	public static final String HORIZONTAL_SCROLL_POSITION = "ScrollPosition";
	public static final String BACKGROUND_IMAGE_NAME = "BackgroundName";
	public static final String CHARACTER_ITERATOR = "CharacterIterator";
	public static final String FOREGROUND_OBJECT_ITERATOR = "ForegroundObjectIterator";
	public static final String HUD_GRAPHIC_SPRITE_CODE = "HUDSpriteCode";
	public static final String HUD_OBJECT_ITERATOR = "HUDObjectIterator";
	public static final String OVERLAY_GRAPHIC_SPRITE_CODE = "OverlaySpriteCode";
	public static final String OVERLAY_OBJECT_ITERATOR = "OverlayObjectIterator";
	
	
	public void loadState(AbstractState state) {
		setModelProperty(GraphicsController.HORIZONTAL_SCROLL_POSITION, state.getScrollPosition());
		setModelProperty(GraphicsController.BACKGROUND_IMAGE_NAME, state.getBackgroundName());
		

		//TODO
	}
	
	/**
	 * @param scrollPosition
	 */
	public void setScrollPosition(int scrollPosition) {
		setModelProperty(GraphicsController.HORIZONTAL_SCROLL_POSITION, scrollPosition);
	}
	
}
