package com.inpeace.graphics;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 0.0
 * @since   24 Mar 2014
 */
public abstract class AbstractController implements PropertyChangeListener {

	private ArrayList<AbstractView> registeredViews;
	private ArrayList<AbstractModel> registeredModels;

	public AbstractController() {
		registeredViews = new ArrayList<AbstractView>();
		registeredModels = new ArrayList<AbstractModel>();
	}

	public void addModel(AbstractModel model) {
		registeredModels.add(model);
		model.addListener(this);
	}

	public void removeModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removeListener(this);
	}

	public void addView(AbstractView view) {
		registeredViews.add(view);
	}

	public void removeView(AbstractView view) {
		registeredViews.remove(view);
	}

	//  Use this to observe property changes from registered models
	//  and propagate them on to all the views.

	@Override
	public void propertyChange(PropertyChangeEvent e) {

		for (AbstractView view: registeredViews) {
			view.update(e);
		}
	}

	/**
	 * Dispatches property change to all registered models with a method named "set" + propertyName,
	 * where the property name is that which is passed as a parameter and must match the propertyName
	 * in the method exactly.
	 * 
	 * @param propertyName
	 * @param newValue
	 */
	protected void setModelProperty(String propertyName, Object newValue) {

		for (AbstractModel model: registeredModels) {
			try {
				Method method = model.getClass().getMethod("set"+propertyName, new Class[] {
						newValue.getClass()
				});
				method.invoke(model, newValue);

			} catch (Exception e) {
				//TODO or NULL BODY???
			}
		}
	}
	
	/**
	 * 
	 */
	public abstract void repaint(Graphics2D g);

}
