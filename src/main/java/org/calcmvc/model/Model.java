package org.calcmvc.model;

import org.calcmvc.common.operation.CommonBase;
import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;

import java.util.ArrayList;

import java.util.List;

/**
 * Generic class describing a Model of the tuple [Model/View/Controller].
 * Each Model is considered as executing an operation
 *
 * @author x. skapin
 */
public abstract class Model<T> extends CommonBase {
    /** Collection of operands upon which operations will be applied */
    protected final List<T> operands = new ArrayList<>();

    /** Depending on operations, a single or several results will be computed. */
    protected final List<T> results = new ArrayList<>();

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType type of computation
     * @param operandType type of operands
     */
    public Model(String description,
                 OperationType operationType,
                 OperandType operandType) {
        super(description, operationType, operandType);
    }

    /**
     * Converts strings as operands of the type related to the concrete subclass.
     * @param operands collection of operands to convert
     * @return true if the conversion has succeeded
     */
    public abstract boolean convertOperandsToType(List<String> operands);

    /**
     * Converts the result of some computation to a string
     * @return the resulting string
     */
    public String convertResultToString() { return this.results.toString(); }

    /**
     * Overrides [MyCommand#execute].
     * Runs the computation defined by the concrete subclass.
     */
    @Override
    public void execute() {
        this.results.clear();
        this.apply(this.operands);
    }

    //// Protected ///

    /**
     * Applies the operation defined by the subclass to all operands.
     * @param operands
     */
    protected abstract void apply(List<T> operands);

}
