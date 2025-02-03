package org.calcmvc.common.operation;

/**
 * Defines the different types of operands.
 * This enumeration could be completed with:
 * <ul>
 *     <li>either "computational" operands (such as [LONG] described below): [DOUBLE], imaginary numbers,...</li>
 *     <li>or "non-computational" operations, for instance to quit the application </li>
 * </ul>other
 *
 * @author x. skapin
 */
public enum OperandType {
    /** For global (non computational) operations */
    EXTRA,

    /** Represents the [Long] type: one kind of "computational" operand */
    LONG,

    /** Default value, which should not be usable. */
    UNKNOWN;
}
