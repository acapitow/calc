package org.calcmvc.view.longview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.view.View;

/**
 * View associated with the "Sub Long" computational operation.
 * This view is part of the tuple SubLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class SubLongView extends View {
    /** Short instance description */
    public final static String DESCRIPTION = OperationType.SUB.name() + " "
             + OperandType.LONG.name() + " operation. "
            + "Shortcut: " + OperationType.SUB.getShortcut();

    //// Public ////

    /** Constructor */
    public SubLongView() {
        super(SubLongView.DESCRIPTION,
                OperationType.SUB,
                OperandType.LONG);
    }
}
