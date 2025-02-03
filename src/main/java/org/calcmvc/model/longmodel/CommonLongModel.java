package org.calcmvc.model.longmodel;

import java.util.List;

/**
 * Singleton gathering methods common to all models operating on Long operands.
 *
 * @author x. skapin
 */
public class CommonLongModel {
    /** Private instance */
    private static CommonLongModel instance;

    //// Public ////

    /** @return the single instance */
    public static CommonLongModel getInstance() {
        if (instance == null)
            instance = new CommonLongModel();
        return instance;
    }

    /**
     * Converts a collection of String values into Long values
     * @param input values to convert
     * @param output contains the result of the conversion
     * @return true if the operation has succeeded
     */
    public boolean convertOperandsToLong(List<String> input,
                                         List<Long> output) {
        output.clear();
        try {
            input.stream().map(Long::parseLong).forEach(output::add);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //// Private ////

    /** Private constructor */
    private CommonLongModel() { }
}
