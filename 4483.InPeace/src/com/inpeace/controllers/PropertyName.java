package com.inpeace.controllers;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   30 Mar 2014
 */
public enum PropertyName {
	STATE_TYPE ("StateType"),
	VIEW ("View"),
	DEFAULT_GRAPHICS_MODEL ("DefaultGraphicsModel"),
	HUD_GRAPHICS_MODEL ("HUDModel"),
	OVERLAY_GRAPHICS_MODEL ("OverlayModel"),
	AUDIO_MODEL ("AudioModel"),
	HORIZONTAL_SCROLL_POSITION ("HorizontalScrollPosition"),
	BACKGROUND_IMAGE_NAME ("BackgroundName"),
	FOREGROUND_OBJECTS ("ForegroundObjects"),
	FOREGROUND_OBJECT_ENTITY ("ForegroundObjectEntity"),
	HUD_GRAPHIC_SPRITE_CODE ("HUDSpriteCode"),
	HUD_OBJECTS ("HUDObjects"),
	HUD_OBJECT_ENTITY ("HUDObjectEntity"),
	HUD_SCREEN_COVERAGE ("HUDScreenCoverage"),
	OVERLAY_GRAPHIC_SPRITE_CODE ("OverlaySpriteCode"),
	OVERLAY_OBJECTS ("OverlayObjects"),
	OVERLAY_OBJECT_ENTITY ("OverlayObjectEntity"),
	BACKGROUND_MUSIC_NAME ("MusicName"),
	BACKGROUND_MUSIC_VOLUME ("MusicVolume"),
	SOUND_EFFECT ("SoundEffect"),
	SOUND_EFFECTS_VOLUME ("FXVolume");
	
	/**   */
	private final String name;       

    /**
     * Constructs a new PropertyNames object.
     *
     * @param name
     */
    private PropertyName(String name) {
        this.name = name;
    }

    /**
     * @param name
     * @return
     */
    public boolean equals(String name){
    	if (name == null) {
    		return false;
    	}
    	else {
    		return this.name.equals(name);
    	}
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString(){
       return name;
    }
}
