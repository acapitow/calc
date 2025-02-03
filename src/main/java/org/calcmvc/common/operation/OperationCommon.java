package org.calcmvc.common.operation;

import org.calcmvc.common.misc.PackageIntrospection;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton used to create operations working on the same operand type
 *
 * @author x. skapin
 */
public class OperationCommon {
    /** Logging utility */
    private static final Logger LOGGER = Logger.getLogger(PackageIntrospection.class.getName());

    /** Private instance */
    private static OperationCommon instance;

    //// Public ////

    /**
     * Constructor
     * @return the single instance of this class
     */
    public static OperationCommon getInstance() {
        if (instance == null)
            instance =  new OperationCommon();
        return instance;
    }

    /**
     * Dynamically explores a given package and create all classes inside which work on the same operand type
     * @param thePackage package in which the classes are located
     * @param operandType the kind of operand shared by the classes to create
     * @return the collection of instances of created classes
     */
    public List<Object> createClassesWithOperandType(Package thePackage,
                                                  OperandType operandType) {
        List<Class<?>> classes = PackageIntrospection.getInstance().getClassesInPackage(thePackage.getName());

        List<Class<?>> validClasses = classes.stream()
                .filter(validClass -> this.hasSameOperandType(validClass, operandType))
                .toList();

        return createInstances(validClasses);
    }

    //// Private ////

    /**
     * Dynamically creates actual instances of classes
     * @param classes collection of classes to instantiate
     * @return the created instances
     */
    private List<Object> createInstances(List<Class<?>> classes) {
        List<Object> instances = new ArrayList<>();
        try {
            for (Class<?> theClass: classes)
                instances.add(theClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            LOGGER.severe("[#createInstances] An error occurred: " + e.getMessage());
            LOGGER.log(Level.FINE, "Detailed error information", e);
        }
        return instances;
    }

    /**
     * Checks whether the [OperandAnnotation] of a given class match some operand type
     * @param theClass class to process
     * @param operandType type to match
     * @return true if [theClass]'s annotation matches [operandType]
     */
    private boolean hasSameOperandType(Class<?> theClass,
                                       OperandType operandType) {
        OperandAnnotation operandAnnotation = theClass.getAnnotation(OperandAnnotation.class);
        return (operandAnnotation != null &&
            operandAnnotation.operandType() == operandType);
    }


    /** Private constructor */
    private OperationCommon() { }
}
