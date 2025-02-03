package org.calcmvc.common.operation;

import org.calcmvc.common.misc.MyCommand;
import org.calcmvc.common.misc.MyConcreteObservable;

/**
 * Parent class of all Model/View/Controller classes. All those classes are associated with specific operation type and operand type.
 *
 * @author x. skapin
 */
public abstract class CommonBase extends MyConcreteObservable implements MyCommand, Comparable<CommonBase> {
    /** Short instance description */
    protected final String description;

    /** Related operation type */
    protected final OperationType operationType;

    /** Related operand type */
    protected final OperandType operandType;

    //// Public ////

    /**
     * Constructor
     * @param theDescription  information about this instance
     * @param theOperationType the operation type set to this instance
     * @param theOperandType the operand type set to this instance
     */
    public CommonBase(String theDescription,
                      OperationType theOperationType,
                      OperandType theOperandType) {
        super();
        this.description = theDescription;
        this.operationType = theOperationType;
        this.operandType = theOperandType;
    }

    /**
     * Compares this instance to another one
     * @param commonBase the object to be compared
     * @return 0 if both instances are equal
     */
    @Override
    public int compareTo(CommonBase commonBase) {
        return this.operationType.compareTo(commonBase.operationType);
    }

    /** @return the information describing this instance */
    public String getDescription() { return this.description; }

    /** @return the operand type associated with this instance */
    public OperandType getOperandType() { return this.operandType; }

    /** @return the operation type associated with this instance */
    public OperationType getOpType() { return this.operationType; }
}
