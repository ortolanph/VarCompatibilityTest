package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

/**
 * Validate the duration of the project.
 * The project duration has to be between <strong>3</strong> and <strong>12</strong> months.
 */
public class DurationValidator implements Validator<Project> {

    private static final Integer MINIMUM_DURATION = 3;

    private static final Integer MAXIMUM_DURATION = 12;

    /**
     * Validate if the project duration has to be between <strong>3</strong> and <strong>12</strong> months.
     *
     * @param project the project instance to be validated
     * @return <code>true</code> if the project duration has to be between <strong>3</strong> and <strong>12</strong> months and <code>false</code> if not
     */
    @Override public boolean validate(Project project) {
        return ((project.getDuration() >= MINIMUM_DURATION) &&
            (project.getDuration() <= MAXIMUM_DURATION));
    }
}
