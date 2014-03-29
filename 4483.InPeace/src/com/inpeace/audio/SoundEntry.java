package com.inpeace.audio;

import java.io.ByteArrayInputStream;

import javax.sound.sampled.AudioFormat;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class SoundEntry {

	/**   */
	private final ByteArrayInputStream stream;
	
	/**   */
	private final AudioFormat format;
	
	/**
	 * Constructs a new SoundEntry object.
	 *
	 * @param stream
	 * @param format
	 */
	public SoundEntry(ByteArrayInputStream stream, AudioFormat format) {
		this.stream = stream;
		this.format = format;
	}

	/**
	 * Get the stream
	 *
	 * @return the stream
	 */
	public ByteArrayInputStream getStream() {
		return stream;
	}

	/**
	 * Get the format
	 *
	 * @return the format
	 */
	public AudioFormat getFormat() {
		return format;
	}
	
	
}
