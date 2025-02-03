package org.calcmvc.controller.longcontroller;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.controller.Controller;

/**
 * Controller associated with the computational subtraction operation between several Long values.
 * This Controller is part of the Tuple SubLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SubLongController extends Controller<Long> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Controller for " +
            OperationType.SUB.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public SubLongController() {
        super(SubLongController.DESCRIPTION,
                OperationType.SUB,
                OperandType.LONG);
    }
}
