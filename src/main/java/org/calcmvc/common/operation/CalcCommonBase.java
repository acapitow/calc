package org.calcmvc.common.operation;

import org.calcmvc.common.misc.MyCommand;
import org.calcmvc.common.misc.MyConcreteObservable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class handles all the [CommonBase] elements of the same type.
 *
 * @author x. skapin
 */
public abstract class CalcCommonBase extends MyConcreteObservable implements MyCommand {
    /** Short instance description */
    protected final String description;

    /** Collection of operations */
    protected final Set<CommonBase> commonBases = new TreeSet<>();

    //// Public ////

    /**
     * Constructor
     * @param theDescription information about this instance
     */
    public CalcCommonBase(String theDescription) {
        this.description = theDescription;
    }

    /** @return the information describing this instance */
    public String getDescription() { return this.description; }

    /**
     * Searches for a given operation stored inside this instance
     * @param operationType operation type
     * @return the first operation matching [operationType], or null if there is no such operation
     */
    public CommonBase getOpCommonBase(OperationType operationType) {
        return this.commonBases.stream().filter(opCommonBase -> opCommonBase.getOpType() == operationType)
                .findFirst().orElse(null);

    }

    /** @return the collection of stored common operations */
    public Set<CommonBase> getOpCommonBases() { return this.commonBases; }

    //// Protected ////

    /**
     * Creates a group of classes associated with a given operand type inside a package
     * @param thePackage package containing the classes
     * @param operandType Type of operand used for a given calculator
     */
    protected abstract void createOpElements(Package thePackage,
                                             OperandType operandType);

    /**
     * Creates all classes related to a specific operand type and located inside a given package
     * @param thePackage package containing the classes to create
     * @param operandType type of the operand used in the global calculator
     * @param theClass class representing the instance to create
     */
    protected void createOpElements(Package thePackage,
                                    OperandType operandType,
                                    Class<? extends CommonBase> theClass) {
        List<Object> instances = OperationCommon.getInstance()
                .createClassesWithOperandType(thePackage, operandType);

        instances.forEach(instance -> this.commonBases
                .add((theClass.cast(instance))));
    }
}
