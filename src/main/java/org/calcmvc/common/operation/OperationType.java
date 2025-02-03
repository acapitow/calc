package org.calcmvc.common.operation;

/**
 * Enumeration listing all kinds of operations (computational or not) enabled by the calculators.
 * This enumeration could be completed with other operations, for example ABS(), EXP(), LOG()...
 * Conversely, some operations can not be applied on any operand type: for instance, SQRT(negative real number) is not defined.
 * Such an operation should be barred.
 *
 * @author x. skapin
 */
public enum OperationType {
    /** Addition */
    ADD ("+"),

    /** Division */
    DIV ("/"),

    /** Multiplication */
    MUL ("*"),

    /** Square(a) = a * a */
    SQUARE ("sq"),

    /** Subtraction */
    SUB ("-"),

    /** Quit the application (non computational) */
    QUIT ("q"),

    /** *Default value. Should not be usable. */
    UNKNOWN ("?");

    private final String shortcut;

    //// Public ////

    /** @return the shortcut of this instance */
    public String getShortcut() { return this.shortcut; }

    //// Private ////

    /**
     * Private constructor
     * @param theShortcut shortcut associated with this instance
     */
    OperationType(String theShortcut) { this.shortcut = theShortcut; }
}
