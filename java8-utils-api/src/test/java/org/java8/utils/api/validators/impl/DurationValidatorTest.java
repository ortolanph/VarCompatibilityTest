package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DurationValidatorTest {

    private static int LOWER_PROJECT_DURATION = -1;

    private static int UPPER_PROJECT_DURATION = 13;

    private static int INTERVAL_PROJECT_DURATION = 6;

    private DurationValidator durationValidator =
        new DurationValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void lowerProjectDuration() throws Exception {
        Project project = utils.projectWithDuration(LOWER_PROJECT_DURATION);
        assertFalse(durationValidator.validate(project));
    }

    @Test
    public void upperBusinessCode() throws Exception {
        Project project = utils.projectWithDuration(UPPER_PROJECT_DURATION);
        assertFalse(durationValidator.validate(project));
    }

    @Test
    public void intervalBusinessCode() throws Exception {
        Project project = utils.projectWithDuration(INTERVAL_PROJECT_DURATION);
        assertTrue(durationValidator.validate(project));
    }

}
