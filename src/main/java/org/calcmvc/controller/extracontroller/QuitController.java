package org.calcmvc.controller.extracontroller;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.controller.Controller;

import java.beans.PropertyChangeEvent;

/**
 * Controller associated with the "Quit" (non-computational) operation.
 * This Controller is part of the Tuple Quit[Model/View/Controller].
 * Every non-computational operation gets the [EXTRA] annotation.
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.EXTRA)
public class QuitController extends Controller<String> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Controller for " +
            OperationType.QUIT.name() + " operation. ";

    //// Public ////

    /** Constructor */
    public QuitController() {
        super(QuitController.DESCRIPTION,
                OperationType.QUIT,
                OperandType.EXTRA);
        initPropertyChangeListener();
    }

    /** Override [Command#execute] */
    @Override
    public void execute() {
        this.view.execute();
        this.model.execute();
    }

    //// Private ////

    /**
     * Handle all notifications sent by the related Model and View observables.
     * This instance can also send its own notifications to its observers.
     */
    private void initPropertyChangeListener() {
        super.propertyChangeListener = (PropertyChangeEvent propertyChangeEvent) -> {
            String property = propertyChangeEvent.getPropertyName();

            if (property.equalsIgnoreCase(OperationType.QUIT.name())) {
                super.getPropertyChangeSupport()
                        .firePropertyChange(OperationType.QUIT.name(), null, null);
            }
        };
    }
}
