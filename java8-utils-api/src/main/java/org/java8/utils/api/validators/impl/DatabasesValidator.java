package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

/**
 * Validate the number of database technology of the project.
 */
public class DatabasesValidator implements Validator<Project> {

    /**
     * Validate if there are database technologies in the project.
     *
     * @param project the project instance to be validated
     * @return <code>true</code> if the project instance has database technologies and <code>false</code> if not
     */
    @Override public boolean validate(Project project) {
        return !project.getDatabases().isEmpty();
    }
}
