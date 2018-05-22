package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.java8.utils.api.validators.Validator;

/**
 * Validate an employee that should not be a boss.
 */
public class EmployeeValidator implements Validator<Employee> {

    /**
     * Validate an employee that should not be a boss.
     *
     * @param employee the employee expected to not be a boss
     * @return <code>true</code> if the employee is not a boss or <code>false</code> if is
     */
    @Override public boolean validate(Employee employee) {
        return !employee.isBoss();
    }
}
