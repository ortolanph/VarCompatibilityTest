package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

public class ProgrammingLanguagesValidator implements Validator<Project> {

    @Override public boolean validate(Project project) {
        return project.getLanguages().size() > 0;
    }
}