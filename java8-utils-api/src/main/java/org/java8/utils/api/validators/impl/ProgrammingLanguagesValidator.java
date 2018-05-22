package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

/**
 * Validate the number of programming languages of the project.
 */
public class ProgrammingLanguagesValidator implements Validator<Project> {

    /**
     * Validate if the project has at least one programming language.
     *
     * @param project the project instance to be validated
     * @return <code>true</code> if the project instance has at least one programming language and <code>false</code> if not
     */
    @Override public boolean validate(Project project) {
        return !project.getLanguages().isEmpty();
    }
}
