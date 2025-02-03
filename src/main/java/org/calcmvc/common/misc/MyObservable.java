package org.calcmvc.common.misc;

import java.beans.PropertyChangeListener;

/**
 * Interface representing the Observable design pattern
 *
 * @author x. skapin
 */
public interface MyObservable {
    /**
     * Adds an observer to this observable
     * @param propertyChangeListener observer to add
     */
    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

    /**
     * Removes an observer from this observable
     * @param propertyChangeListener observer to remove
     */
    void removePropertyChangeListener (PropertyChangeListener propertyChangeListener);
}
