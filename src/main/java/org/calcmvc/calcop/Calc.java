package org.calcmvc.calcop;

import org.calcmvc.common.misc.MyCommand;
import org.calcmvc.common.misc.MyConcreteObservable;
import org.calcmvc.common.operation.OperationType;
import org.calcmvc.controller.CalcController;
import org.calcmvc.controller.Controller;
import org.calcmvc.controller.extracontroller.QuitController;
import org.calcmvc.model.Model;
import org.calcmvc.model.extramodel.QuitModel;
import org.calcmvc.view.View;
import org.calcmvc.view.extraview.QuitView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Generic calculator. It serves as a container for the main application controller.
 * @param <T> Type of the operands
 *
 * @author x. skapin
 */
public abstract class Calc<T> extends MyConcreteObservable implements MyCommand {

    /** Main application controller dedicated to a given type. It manages all sub-controllers. */
    protected final CalcController<T> calcController;

    /** Listener used to process notifications from associated model and view */
    protected PropertyChangeListener propertyChangeListener;

    //// Public ////

    /**
     * Constructor
     * @param theCalcController Controller handling operations on type [T]
     */
    public Calc(CalcController<T> theCalcController) {
        this.calcController = theCalcController;

        initPropertyChangeListener();
        addAllExtraControllers();
    }

    //// Private ////

    /** By default, only controllers managing operations are inserted inside this instance.
     * This method allows to add extra controllers. */
    private void addAllExtraControllers() {
        addQuitController();
        this.calcController.addPropertyChangeListener(this.propertyChangeListener);
    }

    /** Creates and adds a [QuitController] to this instance */
    private void addQuitController() {
        QuitController quitController = new QuitController();
        QuitModel<String> quitModel = new QuitModel<>();
        QuitView quitView = new QuitView();
        quitController.setModel(quitModel);
        quitController.setView(quitView);
        completeExtraControllerConfig(quitController, quitModel, quitView);
    }

    /**
     * Inserts the 3-tuple model/view/controller into this instance
     * @param opController controller associated with a given process
     * @param opModel model associated with the same process
     * @param opView view associated with the same process
     */
    private void completeExtraControllerConfig(Controller<?> opController,
                                               Model<?> opModel,
                                               View opView) {
        opController.addPropertyChangeListener(this.calcController.getPropertyChangeListener());

        this.calcController.getOpCommonBases().add(opController);
        this.calcController.getCalcModel().getOpCommonBases().add(opModel);
        this.calcController.getCalcView().getOpCommonBases().add(opView);
    }

    /** Processes any notification sent by a sub-controller. Some notification may be transferred to an upper level. */
    private void initPropertyChangeListener() {
        this.propertyChangeListener = (PropertyChangeEvent propertyChangeEvent) -> {
            String property = propertyChangeEvent.getPropertyName();
            if (property.equalsIgnoreCase(OperationType.QUIT.name())) {
                super.getPropertyChangeSupport()
                        .firePropertyChange(OperationType.QUIT.name(), null, null);
            }
        };
    }
}
