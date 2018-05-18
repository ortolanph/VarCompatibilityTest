package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

public class DatabasesValidator implements Validator<Project> {

    @Override public boolean validate(Project project) {
        return project.getDatabases().isEmpty();
    }
}
