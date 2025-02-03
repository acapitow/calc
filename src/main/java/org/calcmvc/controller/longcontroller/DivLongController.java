package org.calcmvc.controller.longcontroller;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.controller.Controller;

/**
 * Controller associated with the computational division operation between several Long values.
 * This Controller is part of the Tuple DivLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class DivLongController extends Controller<Long> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Controller for " +
            OperationType.DIV.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public DivLongController() {
        super(DivLongController.DESCRIPTION,
                OperationType.DIV,
                OperandType.LONG);
    }
}
