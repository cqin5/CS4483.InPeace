package com.inpeace.gui.general;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import com.inpeace.images.BufferedImageLoader;

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
	 * Constructor requiring the relative path of the image be passed as an argument.
	 *
	 * @param relativePath	the relative path of the background graphic.
	 */
	public BackgroundPanel(String relativePath) {

		try	{
			//Attempt to load the graphic and set the dimensions of the panel
			background = BufferedImageLoader.loadImage(relativePath);
			Dimension d = new Dimension(background.getWidth(null), background.getHeight(null));
			setPreferredSize(d);
			setMinimumSize(d);
			setMaximumSize(d);
			setSize(d);
		} catch (IOException e) {
			new GeneralDialogue("Oops! It seems we are having trouble locating the image!",
					"Load Error", 1);
		}
	}

	/**
	 * Constructor requiring the relative path of the image, the the dimensions and the
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
			background = BufferedImageLoader.loadImage(relativePath);
		} catch (IOException e) {
			new GeneralDialogue("Oops! It seems we are having trouble locating the image!",
					"Load Error", 1);
		}

		//Set the layout manger to the specified type
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

	/**
	 * Close method, by default no action is performed on close. Subclasses must override
	 * this method if they require actions to be performed on close.
	 */
	public void close() {
		//Null method to be overwritten by screens requiring extra actions on close.
	}
}
