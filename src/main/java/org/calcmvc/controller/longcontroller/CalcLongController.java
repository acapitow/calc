package org.calcmvc.controller.longcontroller;

import org.calcmvc.calcop.calclong.CalcLong;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.controller.CalcController;
import org.calcmvc.model.longmodel.CalcLongModel;
import org.calcmvc.view.longview.CalcLongView;

/**
 * Calculator controller for Long operations.
 * This Controller is part of the Tuple CalcLong[Model/View/Controller].
 *
 * @author x. skapin
 */
public class CalcLongController extends CalcController<Long> {
    /**  Short instance description */
    public final static String DESCRIPTION = "Controller for " +
            OperandType.LONG.name() + " operations";

    //// Public ////

    /**
     * Placeholder to hide the call to the constructor. Useful to initialize a subclass before returning the new instance.
     * @return an instance of this
     */
    public static CalcLongController create() {
        CalcLongController calcLongController = new CalcLongController();
        calcLongController.createOpElements(calcLongController.getClass().getPackage(),
                OperandType.LONG);
        calcLongController.initControllerElements();
        return calcLongController;
    }

    //// Private ////

    /** Constructor */
    private CalcLongController() {
        super(CalcLongController.DESCRIPTION,
                CalcLongModel.create(),
                CalcLongView.create());
    }
}
