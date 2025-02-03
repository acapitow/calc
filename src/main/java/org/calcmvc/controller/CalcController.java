package org.calcmvc.controller;

import org.calcmvc.common.operation.*;
import org.calcmvc.model.CalcModel;
import org.calcmvc.model.Model;
import org.calcmvc.view.CalcView;
import org.calcmvc.view.View;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Abstract class describing a global calculator independent of any type of operands.
 * Any concrete calculator dedicated to a specific operand type should extend this class.
 * This class is part of the tuple Calc[Model/View/Controller].
 * This class runs a loop to:
 *  <ul>
 *      <li>display the available operations</li>
 *      <li>interact with the user</li>
 *      <li>compute the result of the operation</li>
 *  </ul>
 *  The loop stops when the user chooses to quit the application.
 * @param <T> Operand type for concrete children classes
 *
 * @author x. skapin
 */
public abstract class CalcController<T> extends CalcCommonBase {
    /** Model managed by this instance */
    protected final CalcModel<T> calcModel;

    /** View managed by this instance */
    protected final CalcView calcView;

    /** Observer listening to both model and view */
    protected PropertyChangeListener propertyChangeListener;

    /** Check whether the loop continues or not. */
    private boolean stop = false;

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param theCalcModel model related to a specific operand type
     * @param theCalcView view interacting with the user
     */
    public CalcController(String description,
                          CalcModel<T> theCalcModel,
                          CalcView theCalcView) {
        super(description);
        this.calcModel = theCalcModel;
        this.calcView = theCalcView;
        initPropertyChangeListener();
    }

    /**
     * Create all classes related to a specific operand type and located inside a given package
     * @param thePackage package containing the classes to create
     * @param operandType type of the operand used in the global calculator
     */
    @Override
    public void createOpElements(Package thePackage,
                                 OperandType operandType) {
        super.createOpElements(thePackage, operandType, Controller.class);
    }

    /** Override [Command#execute].
     * This method gets the user's choice using the view's instance, then executes the matching controller.
     */
    @Override
    public void execute() {
        while(!stop) {
            this.calcView.execute();

            OperationType operationType = this.calcView.getOpType();
            if (operationType != OperationType.UNKNOWN) {
                if (super.getOpCommonBase(operationType) instanceof Controller<?>)
                    super.getOpCommonBase(operationType).execute();
                else
                    throw new OperationTypeException("[CalcController#execute] Controller not found.");
            }
        }
    }

    /** @return the related calculator model */
    public CalcModel<T> getCalcModel() { return this.calcModel; }

    /** @return the related calculator view */
    public CalcView getCalcView() { return calcView; }

    /** @return the instance's observer */
    public PropertyChangeListener getPropertyChangeListener() { return this.propertyChangeListener; }


    //// Protected ////

    /** Set all children controllers */
    protected void initControllerElements() {
        assert this.calcView != null;
        assert this.calcModel != null;
        for (CommonBase commonBase : super.getOpCommonBases()) {
            if (commonBase instanceof Controller<?>) {
                Controller<T> opController =(Controller<T>) commonBase;

                Model<T> opModel = (Model<T>) (this.calcModel.getOpCommonBase(commonBase.getOpType()));
                View opView = (View) (this.calcView.getOpCommonBase(commonBase.getOpType()));

                opController.setModel(opModel);
                opController.setView(opView);
                opController.addPropertyChangeListener(this.propertyChangeListener);
            }
            else
                throw new OperationTypeException("[CalcController#initControllerElements] Controller not found.");
        }
    }

    //// Private ////

    /**
     * Handle all notifications sent by the related Model and View observables.
     * This instance can also send its own notifications to its observers.
     */
    private void initPropertyChangeListener() {
        this.propertyChangeListener = (PropertyChangeEvent propertyChangeEvent) -> {
            String property = propertyChangeEvent.getPropertyName();

            if (property.equalsIgnoreCase(OperationType.QUIT.name())) {
                this.stop = true;
                super.getPropertyChangeSupport()
                        .firePropertyChange(OperationType.QUIT.name(), null, null);
            }
        };
    }
}
