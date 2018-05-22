package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

import java.util.Objects;

/**
 * Validates if the name is not null or empty.
 */
public class NameValidator implements Validator<Project> {

    private static final String EMPTY_STRING = "";

    /**
     * Validates if the name is not null or empty.
     *
     * @param project the project instance to be validated
     * @return <code>true</code> if name is not null or empty or <code>false</code> if name is null or empty
     */
    @Override public boolean validate(Project project) {
        return !(Objects.isNull(project.getName()) ||
            EMPTY_STRING.equals(project.getName().trim()));
    }
}
