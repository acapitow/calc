package org.calcmvc.model.longmodel;

import org.calcmvc.common.operation.OperandType;
import org.calcmvc.model.CalcModel;

/**
 * Calculator model for Long operations.
 * This model is part of the Tuple CalcLong[Model/View/Controller].
 *
 * @author x. skapin
 */
public class CalcLongModel extends CalcModel<Long> {
    /** Short instance description */
    private final static String DESCRIPTION = "Calc for " +
            OperandType.LONG.name() + " operands";

    //// Public ////

    /** Placeholder to hide the call to the constructor.  */
    public static CalcLongModel create() {
        CalcLongModel calcLongModel = new CalcLongModel();
        calcLongModel.createOpElements(CalcLongModel.class.getPackage(),
                OperandType.LONG);
        return calcLongModel;
    }

    //// Private ////

    /** Constructor */
    private CalcLongModel() {
        super(CalcLongModel.DESCRIPTION);
    }
}
