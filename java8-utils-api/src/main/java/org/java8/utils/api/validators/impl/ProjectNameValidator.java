package org.java8.utils.api.validators.impl;

import org.java8.utils.api.validators.Validator;

import java.util.Objects;

public class ProjectNameValidator implements Validator<String> {

    @Override public boolean validate(String projectName) {
        return !Objects.isNull(projectName);
    }
}
