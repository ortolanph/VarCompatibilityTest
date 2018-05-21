package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProjectInstanceValidatorTest {

    private ProjectInstanceValidator instanceValidator = new ProjectInstanceValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void hasInstance() throws Exception {
        Project project = utils.defaultProject();
        assertTrue(instanceValidator.validate(project));
    }

    @Test
    public void doesntHaveInstance() throws Exception {
        Project project = null;
        assertFalse(instanceValidator.validate(project));
    }

}
