package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.model.UnaryModel;

import java.util.List;

/**
 * Abstract class for computational unary operations on Long operands.
 *
 * @author x. skapin
 */
public abstract class UnaryLongModel extends UnaryModel<Long> {

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType the operation to apply
     */
    public UnaryLongModel(String description,
                          OperationType operationType) {
        super(description, operationType, OperandType.LONG);
    }

    /**
     * Implements [Model#convertOperandsToType].
     * Converts a collection of String to Long values.
     * @param theOperands values to convert
     * @return true if the conversion has succeeded
     */
    @Override
    public boolean convertOperandsToType(List<String> theOperands) {
        return CommonLongModel.getInstance()
                .convertOperandsToLong(theOperands, super.operands);
    }
}
