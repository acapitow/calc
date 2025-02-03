package org.calcmvc.controller;

import org.calcmvc.common.operation.CommonBase;
import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.model.Model;
import org.calcmvc.view.View;

import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Controller independent of operand type. It handles both related model and view.
 * @param <T> type of the operand
 *
 * @author x. skapin
 */
public abstract class Controller<T> extends CommonBase {
    /** Related model */
    protected Model<T> model;

    /** Related view */
    protected View view;

    /** Observer listening to both model and view */
    protected PropertyChangeListener propertyChangeListener;

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType type of the operation
     * @param operandType type of the operands
     */
    public Controller(String description,
                      OperationType operationType,
                      OperandType operandType) {
        super(description, operationType, operandType);
    }

    /**
     * Override Command#execute.
     * This method gets the operands defined by the user using the view's instance, then executes the related operation model.
     */
    @Override
    public void execute() {
        this.view.execute();
        List<String> operands = this.view.getOperands();
        if (this.model.convertOperandsToType(operands)) {
            this.model.execute();
            this.view.displayResult(this.model.convertResultToString());
        }
        else
            this.view.displayError();
    }

    /** @return the related model */
    public Model<T> getModel() { return this.model; }

    /** @return the related view */
    public View getView() { return this.view; }

    /**
     * Set the model of this instance
     * @param theModel model to associate
     */
    public void setModel(Model<T> theModel) {
        this.model = theModel;
        this.model.addPropertyChangeListener(this.propertyChangeListener);
    }

    /**
     * Set the view of this instance
     * @param theView cview to associate
     */
    public void setView(View theView) {
        this.view = theView;
        this.view.addPropertyChangeListener(this.propertyChangeListener);
    }
}
