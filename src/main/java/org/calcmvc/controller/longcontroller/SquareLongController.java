package org.calcmvc.controller.longcontroller;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.controller.Controller;

/**
 * Controller associated with the computational square operation of several Long values.
 * This Controller is part of the Tuple SquareLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SquareLongController extends Controller<Long> {
    public final static String DESCRIPTION = "Controller for " +
            OperationType.SQUARE.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////
    public SquareLongController() {
        super(SquareLongController.DESCRIPTION,
                OperationType.SQUARE,
                OperandType.LONG);
    }
}
