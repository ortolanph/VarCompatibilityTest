package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeValidatorTest {

    private EmployeeValidator employeeValidator = new EmployeeValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void shouldBeAnEmployee() throws Exception {
        Employee employee = utils.employee();
        assertTrue(employeeValidator.validate(employee));
    }

    @Test
    public void shouldNotBeAnEmployee() throws Exception {
        Employee employee = utils.boss();
        assertFalse(employeeValidator.validate(employee));
    }

}
