package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

import java.util.Objects;

/**
 * Validate a Project instance.
 */
public class ProjectInstanceValidator implements Validator<Project> {

    /**
     * Validate a Project instance.
     *
     * @param project the instance to be validated.
     * @return if the instance is not null and if it's from Project class
     */
    @Override public boolean validate(Project project) {
        return (!Objects.isNull(project)) && (project instanceof Project);
    }
}
