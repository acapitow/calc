package org.calcmvc.common.operation;

/**
 * Exception thrown when an element of the tuple Model/View/Controller has not been found.
 * It generally means that the creation of such an element has failed.
 *
 * @author x. skapin
 */
public class OperationTypeException extends RuntimeException {
    /** Unique UID */
    final public static long serialVersionUID = 1L;

    //// Public ////

    /**
     * Constructor
     * @param message displayed when the exception is executed
     */
    public OperationTypeException(String message) {
        super(message);
    }
}
