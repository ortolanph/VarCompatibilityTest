package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

import java.util.Objects;

public class ProjectInstanceValidator implements Validator<Project> {

    @Override public boolean validate(Project project) {
        return Objects.nonNull(project) && (project instanceof Project);
    }
}
