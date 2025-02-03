package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;

/**
 * Model associated with the "Square Long" computational operation.
 * This model is part of the tuple MulLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SquareLongModel extends UnaryLongModel {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.SQUARE.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public SquareLongModel() {
        super(SquareLongModel.DESCRIPTION,
                OperationType.SQUARE);
    }

    /**
     * Implements [UnaryModel#applyUnary].
     * Computes the square of one operand.
     * @param operand value to square
     * @return the result of the square operation
     */
    @Override
    public Long applyUnary(Long operand) {
        return operand * operand;
    }
}
