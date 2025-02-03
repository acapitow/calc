package org.calcmvc.view.longview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.view.View;
import org.calcmvc.common.operation.OperandType;

/**
 * View associated with the "Add Long" computational operation.
 * This view is part of the tuple AddLong[Model/View/Controller].
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.LONG)
public class AddLongView extends View {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.ADD.name() + " "
             + OperandType.LONG.name() + " operation. "
            + "Shortcut: " + OperationType.ADD.getShortcut();

    //// Public ////

    /** Constructor */
    public AddLongView() {
        super(AddLongView.DESCRIPTION,
                OperationType.ADD,
                OperandType.LONG);
    }
}
