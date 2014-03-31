package com.inpeace.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.inpeace.exceptions.MVCException;
import com.inpeace.models.AbstractModel;
import com.inpeace.views.AbstractView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   24 Mar 2014
 */
public abstract class AbstractController implements PropertyChangeListener {

	public static final String MODEL = "Model";
	public static final String VIEW = "View";

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
	 * @throws MVCException 
	 */
	public void registerModel(AbstractModel model) throws MVCException {
		if (registeredModels.add(model)) {
			model.addListener(this);
			model.fireAll();
		}
		else {
			throw new MVCException("Unable to register model, model already registered"
					+ " (AbstractController)");
		}
	}

	/**
	 * @param model
	 * @throws MVCException 
	 */
	public void deregisterModel(AbstractModel model) throws MVCException {
		if (registeredModels.remove(model)) {
			model.removeListener(this);
		}
		else {
			throw new MVCException("Unable to deregister model, model was not registered"
					+ " (AbstractController)");
		}
	}

	/**
	 * @param view
	 * @throws MVCException 
	 */
	public void registerView(AbstractView view) throws MVCException {
		if (!registeredViews.add(view)) {
			throw new MVCException("Unable to register view, view already registered"
					+ " (AbstractController)");
		}
	}

	/**
	 * @param view
	 * @throws MVCException 
	 */
	public void deregisterView(AbstractView view) throws MVCException {
		if (registeredViews.remove(view)) {
			throw new MVCException("Unable to deregister view, view was not registered"
					+ " (AbstractController)");
		}
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

	public void setProperty(String propertyName, Object value) {
		String methodName =  "set" + propertyName;
		for (AbstractModel model: getRegisteredModels()) {
			Method methods[] = model.getClass().getMethods();
			for (Method method: methods) {

				try {
					if (!method.getName().equals(methodName)) {
						continue;
					}
					Class<?>[] paramTypes = method.getParameterTypes();
					if (paramTypes.length != 1) {
						continue;
					}
					else if (!paramTypes[0].isAssignableFrom(value.getClass())) {
						continue;
					}
					method.invoke(model, value);

					break;
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 */
	public void refresh() {
		for (AbstractView view: registeredViews) {
			view.refresh();
		}
	}

	/**
	 * Get the registeredViews
	 *
	 * @return the registeredViews
	 */
	public ArrayList<AbstractView> getRegisteredViews() {
		return registeredViews;
	}

	/**
	 * Get the registeredModels
	 *
	 * @return the registeredModels
	 */
	public ArrayList<AbstractModel> getRegisteredModels() {
		return registeredModels;
	}

}
