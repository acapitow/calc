package org.calcmvc.view.longview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.view.View;

/**
 * View associated with the "Div Long" computational operation.
 * This model is part of the tuple DivLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class DivLongView extends View {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.DIV.name() + " "
             + OperandType.LONG.name() + " operation. "
            + "Shortcut: " + OperationType.DIV.getShortcut();

    //// Public ////

    /** Constructor */
    public DivLongView() {
        super(DivLongView.DESCRIPTION,
                OperationType.DIV,
                OperandType.LONG);
    }
}
