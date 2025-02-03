package org.calcmvc.view.extraview;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.view.View;

/**
 * View associated with the "Quit" (non-computational) operation.
 * This view is part of the Tuple Quit[Model/View/Controller].
 * Every non-computational operation gets the [EXTRA] annotation.
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.EXTRA)
public class QuitView extends View {
    /**  Short instance description */
    public final static String DESCRIPTION = OperationType.QUIT.name() + " "
            + OperandType.LONG.name() + " calc. "
            + "Shortcut: " + OperationType.QUIT.getShortcut();

    //// Public ////

    /** Constructor */
    public QuitView() {
        super(QuitView.DESCRIPTION,
                OperationType.QUIT,
                OperandType.EXTRA);
    }

    /**
     * Overrides [MyCommand#execute].
     * Displays a message to signal the application termination.
     */
    @Override
    public void execute() {
        System.out.println("Bye bye!");
    }
}