package org.calcmvc.model;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;

import java.util.List;

/**
 * Abstract class for computational unary operations on operands of any type.
 * There are as many computed results as there are operands.
 *
 * @author x. skapin
 */
public abstract class UnaryModel<T> extends Model<T> {

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType type of computation
     * @param operandType type of operands
     */
    public UnaryModel(String description,
                      OperationType operationType,
                      OperandType operandType) {
        super(description, operationType, operandType);
    }

    /**
     * Overrides [Model#apply].
     * Applies on operands the binary operation represented by concrete subclasses
     * @param operands collection of values upon which the operation is applied
     */
    @Override
    public void apply(List<T> operands) {
        for (T operand : super.operands)
            super.results.add(applyUnary(operand));
    }

    //// Protected ////

    /**
     * Applies on one operand the unary operation represented by concrete subclasses.
     * @param operand the value upon which the operation is applied
     * @return the result of the operation
     */
    protected abstract T applyUnary(T operand);
}
