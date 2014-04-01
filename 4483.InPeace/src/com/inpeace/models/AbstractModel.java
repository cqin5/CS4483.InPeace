package com.inpeace.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import com.inpeace.controllers.PropertyName;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public abstract class AbstractModel implements Serializable {

	/**   */
	private static final long serialVersionUID = 3207142051740234508L;
	
	/**   */
	protected transient PropertyChangeSupport propertyChangeSupport;
	 
    /**
     * Constructs a new AbstractModel object.
     *
     */
    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
 
    /**
     * @param listener
     */
    public void addListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
 
    /**
     * @param listener
     */
    public void removeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
 
    /**
     * @param propertyName
     * @param newValue
     */
    protected void fireChange(PropertyName propertyName, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName.toString(), null, newValue);
    }
    
    /**
     * 
     */
    public abstract void fireAll();
    
}
