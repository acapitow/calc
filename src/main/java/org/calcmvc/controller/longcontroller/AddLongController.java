package org.calcmvc.controller.longcontroller;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.controller.Controller;

/**
 * Controller associated with the computational addition operation between several Long values.
 * This Controller is part of the Tuple AddLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class AddLongController extends Controller<Long> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Controller for " +
            OperationType.ADD.name() + " "
            + OperandType.LONG.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public AddLongController() {
        super(AddLongController.DESCRIPTION,
                OperationType.ADD,
                OperandType.LONG);
    }
}
