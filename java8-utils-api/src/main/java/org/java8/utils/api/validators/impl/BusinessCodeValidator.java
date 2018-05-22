package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

/**
 * Validate the business code of the project.
 * The business code has to be between <strong>1000</strong> and <strong>9999</strong>.
 */
public class BusinessCodeValidator implements Validator<Project> {

    private static final Integer LOWER_LIMIT = 1000;

    private static final Integer UPPER_LIMIT = 9999;

    /**
     * Validate if the project's business code is between <strong>1000</strong> and <strong>9999</strong>.
     *
     * @param project the project instance to be validated
     * @return <code>true</code> if the project's business code is between <strong>1000</strong> and <strong>9999</strong> and <code>false</code> if not
     */
    @Override public boolean validate(Project project) {
        return ((project.getBusinessCode() >= LOWER_LIMIT) &&
            (project.getBusinessCode() <= UPPER_LIMIT));
    }
}
