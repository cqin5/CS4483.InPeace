package com.inpeace.gui.general;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.inpeace.images.BufferedImageLoader;
import com.inpeace.images.ImageScaler;
import com.inpeace.images.ResourceAccessException;

/**
 * The class BackgroundPanel, a JPanel with a graphic used as a backdrop for most GUI screens.
 * 
 * @author  James Anderson
 * @version 1.1
 * @since   30 November 2013
 */
@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	/** The background to display. */
	private BufferedImage background;

	/**
	 * Constructor requiring the image be passed as an argument.
	 *
	 * @param background	the background graphic.
	 */
	public BackgroundPanel(BufferedImage background) {

		//Set the graphic and dimensions of the panel
		this.background = background;
		Dimension d = new Dimension(background.getWidth(null), background.getHeight(null));
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setSize(d);
	}

	/**
	 * Constructor requiring the relative path of the image be passed as an argument.
	 *
	 * @param relativePath	the relative path of the background graphic.
	 */
	public BackgroundPanel(String relativePath) {

		try	{
			//Attempt to load the graphic and set the dimensions of the panel
			background = BufferedImageLoader.getInstance().loadImage(relativePath);
			Dimension d = new Dimension(background.getWidth(null), background.getHeight(null));
			setPreferredSize(d);
			setMinimumSize(d);
			setMaximumSize(d);
			setSize(d);
		} catch (ResourceAccessException e) {
			new GeneralDialogue(e.getMessage(), "Resource Access Error", 1);
		}
	}

	/**
	 * Constructor requiring the image, the the dimensions and the
	 * layout be passed as arguments.
	 *
	 * @param background	the background image.
	 * @param width			the desired width of the new background panel.
	 * @param height		the desired height of the new background panel.
	 * @param layout 		the layout for the new background panel.
	 */
	public BackgroundPanel(BufferedImage background, int width, int height, LayoutManager layout) {

		//Set the panel dimensions based on the arguments passed
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setSize(d);

		//Set image and scale it
		background = this.background;
		background = ImageScaler.scale(background, width, height);

		//Set the layout manger to the specified type
		setLayout(layout);
	}

	/**
	 * Constructor requiring the image, the the dimensions and the
	 * layout be passed as arguments.
	 *
	 * @param relativePath	the relative path of the background image.
	 * @param width			the desired width of the new background panel.
	 * @param height		the desired height of the new background panel.
	 * @param layout 		the layout for the new background panel.
	 */
	public BackgroundPanel(String relativePath, int width, int height, LayoutManager layout) {

		//Set the panel dimensions based on the arguments passed
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setSize(d);

		//Attempt to load the background image, if can't throw exception
		try	{
			background = BufferedImageLoader.getInstance().loadImage(relativePath);
			background = ImageScaler.scale(background, width, height);
		} catch (ResourceAccessException e) {
			new GeneralDialogue(e.getMessage(), "Resource Access Error", 1);
		}

		//Set the layout manger to the specified type
		setLayout(layout);
	}

	/**
	 * Constructor requiring the relative path of the image, the the dimensions and the
	 * layout be passed as arguments.
	 *
	 * @param background	the background image.
	 * @param dimensions	the desired dimensions of the new background panel.
	 * @param layout 		the layout for the new background panel.
	 */
	public BackgroundPanel(BufferedImage background, Dimension dimensions, LayoutManager layout) {
		this(background, dimensions.width, dimensions.height, layout);
	}
	
	/**
	 * Constructor requiring the relative path of the image, the the dimensions and the
	 * layout be passed as arguments.
	 *
	 * @param relativePath	the relative path of the background image.
	 * @param dimensions	the desired dimensions of the new background panel.
	 * @param layout 		the layout for the new background panel.
	 */
	public BackgroundPanel(String relativePath, Dimension dimensions, LayoutManager layout) {
		this(relativePath, dimensions.width, dimensions.height, layout);
	}

	/**
	 * Instantiates a new background panel with graphic and specified layout.
	 *
	 * @param background	the background image.
	 * @param layout		the layout for the new background panel.
	 */
	public BackgroundPanel(BufferedImage background, LayoutManager layout) {

		//Call the basic constructor
		this(background);

		//Set the layout manager to the specified type
		setLayout(layout);
	}

	/**
	 * Instantiates a new background panel with graphic and specified layout.
	 *
	 * @param relativePath	the relative path of the background image.
	 * @param layout		the layout for the new background panel.
	 */
	public BackgroundPanel(String relativePath, LayoutManager layout) {

		//Call the basic constructor
		this(relativePath);

		//Set the layout manager to the specified type
		setLayout(layout);
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {

		//Paint the background
		g.drawImage(background, 0, 0, null);
	}

}
