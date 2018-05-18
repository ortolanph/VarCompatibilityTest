package org.java8.utils.api.validators.impl;

import org.java8.utils.api.validators.Validator;

public class BusinessCodeValidator implements Validator<Integer> {

    private static final Integer LOWER_LIMIT = 1000;

    private static final Integer UPPER_LIMIT = 9999;

    @Override public boolean validate(Integer businessCode) {
        return (businessCode >= LOWER_LIMIT) && (businessCode <= UPPER_LIMIT);
    }
}
