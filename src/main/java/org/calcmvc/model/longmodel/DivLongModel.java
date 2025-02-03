package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.common.operation.OperandAnnotation;

/**
 * Model associated with the "Div Long" computational operation.
 * This model is part of the tuple DivLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class DivLongModel extends BinaryLongModel {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.DIV.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public DivLongModel() {
        super(DivLongModel.DESCRIPTION,
                OperationType.DIV);
    }

    /**
     * Implements [BinaryModel#applyBinary].
     * Applies the division between two operands, except if the denominator is not valid.
     * @param operand1 numerator
     * @param operand2 denominator
     * @return the result of the division. If the denominator is invalid, return [operand1] only.
     */
    @Override
    public Long applyBinary(Long operand1,
                            Long operand2) {
        if (this.isOperandValid(operand2))
            return operand1 / operand2;
        else
            return operand1;
    }

    //// Private ////

    /**
     * Determines if a given operand is valid for this operation.
     * @param operand value to check
     * @return true is the operand is valid
     */
    public boolean isOperandValid(Long operand) { return (operand != 0L); }
}
