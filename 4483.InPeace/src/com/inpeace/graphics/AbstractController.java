package com.inpeace.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public abstract class AbstractController implements PropertyChangeListener {

	/**   */
	private ArrayList<AbstractView> registeredViews;
	
	/**   */
	private ArrayList<AbstractModel> registeredModels;

	/**
	 * Constructs a new AbstractController object.
	 *
	 */
	public AbstractController() {
		registeredViews = new ArrayList<AbstractView>();
		registeredModels = new ArrayList<AbstractModel>();
	}

	/**
	 * @param model
	 */
	public void addModel(AbstractModel model) {
		registeredModels.add(model);
		model.addListener(this);
	}

	/**
	 * @param model
	 */
	public void removeModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removeListener(this);
	}

	/**
	 * @param view
	 */
	public void addView(AbstractView view) {
		registeredViews.add(view);
	}

	/**
	 * @param view
	 */
	public void removeView(AbstractView view) {
		registeredViews.remove(view);
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
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

}
