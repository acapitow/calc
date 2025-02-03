package org.calcmvc.common.misc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class handles the [PropertyChangeListener] observable.
 * Each concrete class extending this one will be able to send property-based notifications to their observers.
 *
 * @author x. skapin
 */
public abstract class MyConcreteObservable implements MyObservable {
    /** Observers container */
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    //// Public ////

    /** Constructor */
    public MyConcreteObservable() { }

    /**
     * Inserts an observer into the container
     * @param propertyChangeListener observer to insert
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    /** @return the observers container */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    /**
     * Removes an observer from the container
     * @param propertyChangeListener observer to insert
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
}
