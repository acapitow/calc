package org.calcmvc.model.extramodel;

import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandAnnotation;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.model.Model;

import java.util.List;

/**
 * Model associated with the "Quit" (non-computational) operation.
 * This model is part of the Tuple Quit[Model/View/Controller].
 * Every non-computational operation gets the [EXTRA] annotation.
 *
 * @author x. skapin
 */
@OperandAnnotation(operandType = OperandType.EXTRA)
public class QuitModel<T> extends Model<T> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Model for " +
            OperationType.QUIT.name() + " operation";

    //// Public ////

    /** Constructor */
    public QuitModel() {
        super(QuitModel.DESCRIPTION,
                OperationType.QUIT,
                OperandType.UNKNOWN);
    }

    /**
     * Implements [Model#apply].
     * This method actually does nothing since this model is not a computational operation.
     * @param operands Operands upon which apply an operation
     */
    @Override
    public void apply(List<T> operands) { }

    /**
     * Implements [Model#convertOperandsToType].
     * Converts a collection of strings representing some operands to some type adequate for applying an operation.
     * @param operands collection of operands to process
     * @return true whatever the operands given as parameters
     */
    @Override
    public boolean convertOperandsToType(List<String> operands) { return true; }

    /**
     * Overrides [Command#execute].
     * Sends a notification for the application to quit.
     */
    @Override
    public void execute() {
        super.getPropertyChangeSupport().firePropertyChange(OperationType.QUIT.name(),
                null, null);
    }
}
