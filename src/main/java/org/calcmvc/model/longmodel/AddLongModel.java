package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.common.operation.OperandAnnotation;

/**
 * Model associated with the "Add Long" computational operation.
 * This model is part of the tuple AddLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class AddLongModel extends BinaryLongModel {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.ADD.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public AddLongModel() {
        super(AddLongModel.DESCRIPTION,
                OperationType.ADD);
    }

    /**
     * Implements [BinaryModel#applyBinary].
     * Applies the addition of two operands.
     * @param operand1 first operand
     * @param operand2 second operand
     * @return the result of the addition
     */
    @Override
    public Long applyBinary(Long operand1,
                      Long operand2) {
        return operand1 + operand2;
    }
}
