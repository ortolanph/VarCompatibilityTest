package org.java8.utils.api.validators;

/**
 * Generic interface to validators.
 *
 * @param <E> the param to check
 */
@FunctionalInterface
public interface Validator<E> {

    /**
     * Makes the validation.
     *
     * @param e instance of a generic object of class E
     * @return <code>true</code> if the value makes sense and <code>false</code> if doesn't
     */
    boolean validate(E e);

}
