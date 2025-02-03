package org.calcmvc.view;

import org.calcmvc.common.operation.CalcCommonBase;
import org.calcmvc.common.operation.OperationType;
import org.calcmvc.common.operation.OperandType;

import java.util.Scanner;

/**
 * Generic calculator view for operands of any type.
 * This model is part of the tuple Calc[Model/View/Controller].
 *
 * @author x. skapin
 */
public abstract class CalcView extends CalcCommonBase {
    /** Default operation type */
    protected OperationType operationType = OperationType.UNKNOWN;

    //// Public ////
    public CalcView(String description) {
        super(description);
    }

    /**
     * Overrides [CalcCommonBase#createOpElements]
     * Creates all View classes related to a specific operand type and located inside a given package
     * @param thePackage package containing the classes to create
     * @param operandType type of the operand used in the global calculator
     */
    @Override
    public void createOpElements(Package thePackage,
                                 OperandType operandType) {
        super.createOpElements(thePackage, operandType, View.class);
    }

    /** Displays the description of all Views managed by this instance */
    public void displayElementsDescription() {
        super.commonBases.forEach(op -> System.out.println(op.getDescription()));
    }

    /**
     * Overrides [MyCommand#execute]
     * Acts as a menu choice:
     * <ul>
     *     <li>displays all actions available to the user</li>
     *     <li>gets the user choice (and detects invalid choices)</li>
     * </ul>
     */
    @Override
    public void execute() {
        System.out.println(super.description);
        this.displayElementsDescription();
        System.out.print("Your choice : ");

        this.operationType = this.convertRequestToOpType(this.requestOp());
        if (this.operationType == OperationType.UNKNOWN)
            System.err.println("Unknow operator.");
    }

    /** @return the [OperationType] related to this instance */
    public OperationType getOpType() { return this.operationType; }

    //// Private ////

    /**
     * Gets the user choice as a string and converts it to an [OperationType]. We assume that such a choice is valid.
     * @param choice the user choice
     * @return the result of the conversion, or [OperationType.UNKNOWN] if the choice is invalid.
     */
    private OperationType convertRequestToOpType(String choice) {
        for (OperationType operationType : OperationType.values())
            if (operationType.name().equalsIgnoreCase(choice) || operationType.getShortcut().equalsIgnoreCase((choice)))
                return operationType;

        return OperationType.UNKNOWN;
    }

    /**
     * Asks the user to chhose an operation to apply
     * @return the iser choice as a string
     */
    private String requestOp() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String request =  scanner.next();
        return request;
    }
}
