package com.inpeace.graphics;

import java.awt.Dimension;
import java.io.Serializable;

import com.inpeace.exceptions.SpriteCodeException;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class SpriteCode implements Serializable {

	/**   */
	private static final long serialVersionUID = 4414129811394561762L;
	
	/**   */
	public final int sheet;
	public final int x;
	public final int y;
	public final int width;
	public final int height;
	public final int versions;
	public final int sets;

	/**
	 * Constructs a new SpriteCode object.
	 *
	 * @param spriteCode
	 * @throws SpriteCodeException 
	 */
	private SpriteCode(String spriteCode) throws SpriteCodeException {
		String[] codes = spriteCode.split("-");
		try {
			sheet = Integer.parseInt(codes[0]);
			x = Integer.parseInt(codes[1]);
			y = Integer.parseInt(codes[2]);
			width = Integer.parseInt(codes[3]);
			height = Integer.parseInt(codes[4]);
			versions = Integer.parseInt(codes[5]);
			sets = Integer.parseInt(codes[6]);
		} catch (NumberFormatException e) {
			throw new SpriteCodeException("Opps! It seems " + spriteCode 
					+ " is not a valid spriteCode:(  (SpriteCode)");
		}
	}
	
	/**
	 * Constructs a new SpriteCode object.
	 *
	 * @param codes
	 * @throws SpriteCodeException 
	 */
	private SpriteCode(int... codes) throws SpriteCodeException {
		if (codes.length == 7) {
			for (int code: codes) {
				if (code < 0) {
					throw new SpriteCodeException("Opps! It seems we have the wrong"
							+ "number of codes:(  7 are required to form a sprite "
							+ "code. (SpriteCode)");
				}
			}
		sheet = codes[0];
		x = codes[1];
		y = codes[2];
		width = codes[3];
		height = codes[4];
		versions = codes[5];
		sets = codes[6];
		}
		else {
			throw new SpriteCodeException("Opps! It seems we have the wrong"
					+ "number of codes:(  7 are required to form a sprite "
					+ "code. (SpriteCode)");
		}
	}

	/**
	 * @param spriteCode
	 * @return
	 * @throws SpriteCodeException 
	 */
	public static SpriteCode get(String spriteCode) throws SpriteCodeException {
		return new SpriteCode(spriteCode);
	}
	
	/**
	 * @param codes
	 * @return
	 * @throws SpriteCodeException
	 */
	public static SpriteCode get(int... codes) throws SpriteCodeException {
		return new SpriteCode(codes);
	}

	/**
	 * @param spriteCode
	 * @param rowsDown
	 * @param columnsAcross
	 * @return
	 */
	public SpriteCode convertCode(int rowsDown, int columnsAcross) {
		SpriteCode code = null;
		try {
			code = new SpriteCode(sheet, x + (columnsAcross * width), y + (rowsDown * height),
					width, height, versions, sets);
		} catch (SpriteCodeException e) {
			//NULL BODY
		}
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String code = "" + sheet;
		code += "-" + x;
		code += "-" + y;
		code += "-" + width;
		code += "-" + height;
		code += "-" + versions;
		code += "-" + sets;

		return code;
	}

	/**
	 * @return
	 */
	public Dimension getDimensions() {
		return new Dimension(width, height);
	}
}
