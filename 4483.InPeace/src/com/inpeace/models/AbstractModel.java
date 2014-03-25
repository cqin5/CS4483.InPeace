package com.inpeace.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public abstract class AbstractModel {

	/**   */
	protected PropertyChangeSupport propertyChangeSupport;
	 
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
     * @param oldValue
     * @param newValue
     */
    protected void fireChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
}
