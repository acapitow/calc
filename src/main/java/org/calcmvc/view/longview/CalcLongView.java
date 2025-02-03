package org.calcmvc.view.longview;

import org.calcmvc.model.longmodel.CalcLongModel;
import org.calcmvc.view.CalcView;
import org.calcmvc.common.operation.OperandType;

/**
 * Calculator view for Long operations.
 * This view is part of the Tuple CalcLong[Model/View/Controller].
 *
 * @author x. skapin
 */
public class CalcLongView extends CalcView {
    /** Short instance description */
    public final static String DESCRIPTION = "Calculator for "
            + OperandType.LONG.name() + " operands." +
            " Select one operation's shortcut below.";

    //// Public ////

    /** Placeholder to hide the call to the constructor.  */
    public static CalcLongView create() {
        CalcLongView calcLongView = new CalcLongView();
        calcLongView.createOpElements(CalcLongView.class.getPackage(),
                OperandType.LONG);
        return calcLongView;
    }

    //// Private ////

    /** Constructor */
    private CalcLongView() {
        super(CalcLongView.DESCRIPTION);
    }
}
