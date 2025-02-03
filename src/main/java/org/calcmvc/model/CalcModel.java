package org.calcmvc.model;


import org.calcmvc.common.operation.CalcCommonBase;
import org.calcmvc.common.operation.OperandType;

/**
 * Generic calculator model for operands of any type.
 * This model is part of the tuple Calc[Model/View/Controller].
 *
 * @author x. skapin
 */
public abstract class CalcModel<T> extends CalcCommonBase {
    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     */
    public CalcModel(String description) {
        super(description);
    }

    /**
     * Overrides [CalcCommonBase#createOpElements]
     * Creates all Model classes related to a specific operand type and located inside a given package
     * @param thePackage package containing the classes to create
     * @param operandType type of the operand used in the global calculator
     */
    @Override
    public void createOpElements(Package thePackage,
                                 OperandType operandType) {
        super.createOpElements(thePackage, operandType, Model.class);
    }

    /**
     * Overrides [MyCommand#execute].
     * Actually does nothing.
     */
    @Override
    public void execute() {}
}