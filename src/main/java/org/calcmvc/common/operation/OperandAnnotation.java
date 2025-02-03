package org.calcmvc.common.operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation allowing to distinguish operations with regard to the operand type they manipulate.
 * This annotation is useful to dynamically create instance of related classes.
 *
 * @author x. skapin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperandAnnotation {
    OperandType operandType() default OperandType.UNKNOWN;
}
