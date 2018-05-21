package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NameValidatorTest {

    private final String PROJECT_NAMED = "java8-utils-api";

    private final String PROJECT_UNNAMED = "";

    private final String PROJECT_NULL_NAMED = null;

    private NameValidator nameValidator = new NameValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void validateNamedProject() throws Exception {
        Project project = utils.projectWithName(PROJECT_NAMED);
        assertTrue(nameValidator.validate(project));
    }

    @Test
    public void validateNameslessProject() throws Exception {
        Project project = utils.projectWithName(PROJECT_UNNAMED);
        assertFalse(nameValidator.validate(project));
    }

    @Test
    public void validateNullNamedProject() throws Exception {
        Project project = utils.projectWithName(PROJECT_NULL_NAMED);
        assertFalse(nameValidator.validate(project));
    }

}
