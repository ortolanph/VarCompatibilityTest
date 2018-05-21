package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BusinessCodeValidatorTest {

    private static int LOWER_BUSINESS_CODE = -1000;

    private static int UPPER_BUSINESS_CODE = 10000;

    private static int INTERVAL_BUSINESS_CODE = 5000;

    private BusinessCodeValidator businessCodeValidator =
        new BusinessCodeValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void lowerBusinessCode() throws Exception {
        Project project = utils.projectWithBusinessCode(LOWER_BUSINESS_CODE);
        assertFalse(businessCodeValidator.validate(project));
    }

    @Test
    public void upperBusinessCode() throws Exception {
        Project project = utils.projectWithBusinessCode(UPPER_BUSINESS_CODE);
        assertFalse(businessCodeValidator.validate(project));
    }

    @Test
    public void intervalBusinessCode() throws Exception {
        Project project = utils.projectWithBusinessCode(INTERVAL_BUSINESS_CODE);
        assertTrue(businessCodeValidator.validate(project));
    }

}
