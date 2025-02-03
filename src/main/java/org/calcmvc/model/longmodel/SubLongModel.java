package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.common.operation.OperandAnnotation;

/**
 * Model associated with the "Sub Long" computational operation.
 * This model is part of the tuple SubLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SubLongModel extends BinaryLongModel {
    /** Short instance description */
    public final static String DESCRIPTION = OperationType.DIV.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public SubLongModel() {
        super(SubLongModel.DESCRIPTION,
                OperationType.SUB);
    }

    /**
     * Implements [BinaryModel#applyBinary].
     * Applies the subtraction of two operands.
     * @param operand1 first operand
     * @param operand2 second operand
     * @return the result of the multiplication
     */
    @Override
    public Long applyBinary(Long operand1,
                            Long operand2) {
        return operand1 - operand2;
    }
}
