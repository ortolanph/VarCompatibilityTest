package org.java8.utils.api.validators;

@FunctionalInterface
public interface Validator<E> {

    boolean validate(E e);

}
