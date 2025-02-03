package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.model.BinaryModel;

import java.util.List;

/**
 * Parent class for all models operating on two Long operands
 *
 * @author x. skapin
 */
public abstract class BinaryLongModel extends BinaryModel<Long> {

    //// Public ////

    /**
     * Constructor
     * @param description Short instance description
     * @param operationType Computational type of operation
     */
    public BinaryLongModel(String description,
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
