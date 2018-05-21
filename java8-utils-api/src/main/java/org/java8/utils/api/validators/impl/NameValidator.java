package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

import java.util.Objects;

public class NameValidator implements Validator<Project> {

    private static final String EMPTY_STRING = "";

    @Override public boolean validate(Project project) {
        return !(Objects.isNull(project.getName()) ||
            EMPTY_STRING.equals(project.getName().trim()));
    }
}
