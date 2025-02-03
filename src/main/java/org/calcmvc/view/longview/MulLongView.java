package org.calcmvc.view.longview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.view.View;

/**
 * View associated with the "Mul Long" computational operation.
 * This view is part of the tuple MulLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class MulLongView extends View {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.MUL.name() + " "
             + OperandType.LONG.name() + " operation. "
            + "Shortcut: " + OperationType.MUL.getShortcut();

    //// Public ////

    /** Constructor */
    public MulLongView() {
        super(MulLongView.DESCRIPTION,
                OperationType.MUL,
                OperandType.LONG);
    }
}
