package org.calcmvc.view;

import org.calcmvc.common.operation.CommonBase;
import org.calcmvc.common.operation.OperandType;
import org.calcmvc.common.operation.OperationType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Generic class describing a View of the tuple [Model/View/Controller].
 * Each view is considered as executing an operation.
 *
 * @author x. skapin
 */
public abstract class View extends CommonBase {
    /** Collection of operands as strings. Its contents are set by the user for each operation. */
    private final List<String> operands = new ArrayList<>();

    //// Public ////

    /**
     * Constructor
     * @param description short instance description
     * @param operationType type of computation
     * @param operandType type of operands
     */
    public View(String description,
                OperationType operationType,
                OperandType operandType) {
        super(description, operationType, operandType);
    }

    /** Error message when applying an operation. Most of the time, the cause is an invalid operand. */
    public void displayError() {
        System.err.println("Error during " + this.operationType.name()
                + ". Maybe a " + this.operandType.name() + " operand was invalid.");
    }

    /** Displays the result of an operation */
    public void displayResult(String result) {
        System.out.println("The result of " + this.operationType.name()
            + " " + this.operandType.name() + " is " + result + "." );
    }

    /**
     * Overrides [MyCommand.execute].
     * Asks the user for a sequence (at least one) of operands upon which some operation will be applied.
     */
    @Override
    public void execute() {
        this.reset();
        System.out.println("Enter the sequence of space-separated operands.");
        this.requestOperands();
    }

    /** @return the description of this instance */
    public String getDescription() { return this.description; }

    /** @return the collection of operands entered by the user */
    public List<String> getOperands() { return this.operands; }

    /** @return the shortcut associated with each operation */
    public String getShortcut() { return this.operationType.getShortcut(); }

    //// Private ////

    /** Asks the user for the sequence of operands */
    private void requestOperands() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String operands = scanner.next();

        // "\\s+" means at least one blank space
        String[] tokens = operands.split("\\s+");
        if (tokens.length == 0)
            System.out.println("At least one operand is required.");
        else
            Arrays.stream(tokens).forEach(this.operands::add);
    }

    /** Empties the collection of operands used in some previous operation. */
    private void reset() { this.operands.clear(); }
}
