package com.inpeace.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.inpeace.engine.Request;
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
	 */
	public void registerModel(AbstractModel model) {
		registeredModels.add(model);
		model.addListener(this);
		model.fireAll();
	}

	/**
	 * @param model
	 */
	public void deregisterModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removeListener(this);
	}

	/**
	 * @param view
	 */
	public void registerView(AbstractView view) {
		registeredViews.add(view);
	}

	/**
	 * @param view
	 */
	public void deregisterView(AbstractView view) {
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
	 * @param request
	 */
	public void processRequest(Request request) {

		switch (request.type) {
		case CHANGE_PROPERTY:
			//Fall through on purpose
		case CLEAR_PROPERTY:
			processPropertyRequest(request);
			break;
		case DEREGISTER:
			if (request.propertyName.equals(MODEL)) {
				deregisterModel((AbstractModel) request.value);
			}
			else if (request.propertyName.equals(VIEW)) {
				deregisterView((AbstractView) request.value);
			}
			break;
		case REGISTER:
			if (request.propertyName.equals(MODEL)) {
				registerModel((AbstractModel) request.value);
			}
			else if (request.propertyName.equals(VIEW)) {
				registerView((AbstractView) request.value);
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param request
	 */
	private void processPropertyRequest(Request request) {
		try {
			String methodName = "";
			switch (request.type) {
			case CHANGE_PROPERTY:
				methodName =  "set" + request.propertyName;
				break;
			case CLEAR_PROPERTY:
				methodName =  "clear" + request.propertyName;
				break;
			default:
				throw new Exception();			
			}

			for (AbstractModel model: registeredModels) {
				Method methods[] = model.getClass().getMethods();
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
			}
		} catch (Exception e) {
			//NULL BODY
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
