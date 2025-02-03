package org.calcmvc.model;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;

import java.util.Iterator;
import java.util.List;

/**
 * Abstract class for computational binary operations on operands of any type.
 * A single result is computed after each operation applied on all valid operands.
 *
 * @author x. skapin
 */
public abstract class BinaryModel<T> extends Model<T> {

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType type of computation
     * @param operandType type of operands
     */
    public BinaryModel(String description,
                       OperationType operationType,
                       OperandType operandType) {
        super(description, operationType, operandType);
    }

    /**
     * Overrides [Model#apply].
     * Applies on operands the binary operation represented by concrete subclasses.
     * @param operands collection of values upon which the operation is applied
     */
    @Override
    public void apply(List<T> operands) {
        Iterator<T> iterator = super.operands.iterator();
        T result = iterator.next();
        while (iterator.hasNext())
            result = applyBinary(result, iterator.next());
        super.results.add(result);
    }

    //// Protected ////

    /**
     * Applies on two operands the binary operation represented by concrete subclasses
     * @param operand1 first operand
     * @param operand2 second operand
     * @return the result of the operation
     */
    protected abstract T applyBinary(T operand1,
                                     T operand2);
}
