package org.calcmvc.calcop.calclong;

import org.calcmvc.calcop.Calc;
import org.calcmvc.controller.longcontroller.CalcLongController;

/**
 * Calculator dedicated to operations on Long type.
 *
 * @author X. skapin
 */
public class CalcLong extends Calc<Long> {

    //// Public ////

    /**
     * Placeholder to hide the call to the constructor. Useful to initialize a subclass before returning the new instance.
     * @return an instance of this
     */
    public static CalcLong create() {
        return new CalcLong();
    }

    /** Overrides [Command#execute]
     * Starts the calculator. */
    @Override
    public void execute() {
        super.calcController.execute();
    }

    //// Private ////

    /** Constructor */
    private CalcLong() {
        ////super(new CalcLongController());
        super(CalcLongController.create());
    }
}
