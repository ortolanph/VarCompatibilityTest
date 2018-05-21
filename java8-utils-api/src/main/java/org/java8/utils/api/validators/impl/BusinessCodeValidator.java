package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

public class BusinessCodeValidator implements Validator<Project> {

    private static final Integer LOWER_LIMIT = 1000;

    private static final Integer UPPER_LIMIT = 9999;

    @Override public boolean validate(Project project) {
        return ((project.getBusinessCode() >= LOWER_LIMIT) &&
            (project.getBusinessCode() <= UPPER_LIMIT));
    }
}
