package org.calcmvc.view.longview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.view.View;

/**
 * View associated with the "Square Long" computational operation.
 * This view is part of the tuple MulLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SquareLongView extends View {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.SQUARE.name() + " "
             + OperandType.LONG.name() + " operation. "
            + "Shortcut: " + OperationType.SQUARE.getShortcut();

    //// Public ////

    /** Constructor */
    public SquareLongView() {
        super(SquareLongView.DESCRIPTION,
                OperationType.SQUARE,
                OperandType.LONG);
    }
}
