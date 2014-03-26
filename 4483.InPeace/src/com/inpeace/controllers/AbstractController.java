package com.inpeace.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.inpeace.engine.ChangeRequest;
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
	 * @param request
	 */
	public void processRequest(ChangeRequest request) {

		for (AbstractModel model: registeredModels) {
			try {
				Method methods[] = model.getClass().getMethods();
				String methodName = "set" + request.propertyName;
				for (Method method: methods) {
					if (!method.getName().equals(methodName)) {
						continue;
					}
					Class<?>[] paramTypes = method.getParameterTypes();
					if (paramTypes.length != 1) {
						continue;
					}
					else if (!paramTypes[0].isAssignableFrom((request.value).getClass())) {
						continue;
					}
					method.invoke(model, request.value);
					break;
				}

			} catch (Exception e) {
				//NULL BODY
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

}
