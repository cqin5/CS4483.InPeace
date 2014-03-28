package com.inpeace.graphics;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   28 Mar 2014
 */
public class SpriteCodeUtility {

	/**
	 * @param spriteCode
	 * @param rowsDown
	 * @param columnsAcross
	 * @return
	 */
	public static String convertCode(String spriteCode, int rowsDown, int columnsAcross) {
		try {
			String[] chunks = spriteCode.split("-");
			int x = Integer.parseInt(chunks[1]);
			int y = Integer.parseInt(chunks[2]);
			int width = Integer.parseInt(chunks[3]);
			int height = Integer.parseInt(chunks[4]);
			
			chunks[1] = Integer.toString(x + (columnsAcross * width));
			chunks[2] = Integer.toString(y + (rowsDown * height));
			
			return chunks[0] + "-" + chunks[1] + "-" + chunks[2] + "-" + chunks[3] + "-" + chunks[4];
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * @param spriteCode
	 * @return
	 */
	public static int getSpriteWidth(String spriteCode) {
		try {
			String[] chunks = spriteCode.split("-");
			return Integer.parseInt(chunks[3]);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
