package org.java8.utils.api.validators.impl;

import org.java8.utils.api.validators.Validator;

public class ProjectDurationValidator implements Validator<Integer> {

    private static final Integer MINIMUM_DURATION = 3;

    private static final Integer MAXIMUM_DURATION = 12;

    @Override public boolean validate(Integer duration) {
        return (duration >= MINIMUM_DURATION) && (duration <= MAXIMUM_DURATION);
    }
}
