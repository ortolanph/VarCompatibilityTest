package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

public class DurationValidator implements Validator<Project> {

    private static final Integer MINIMUM_DURATION = 3;

    private static final Integer MAXIMUM_DURATION = 12;

    @Override public boolean validate(Project project) {
        return ((project.getDuration() >= MINIMUM_DURATION) &&
            (project.getDuration() <= MAXIMUM_DURATION));
    }
}
