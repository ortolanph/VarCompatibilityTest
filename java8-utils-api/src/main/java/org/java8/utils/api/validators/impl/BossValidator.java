package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.java8.utils.api.validators.Validator;

/**
 * Validate an employee that should be a boss.
 */
public class BossValidator implements Validator<Employee> {

    /**
     * Validate an employee that should be a boss.
     *
     * @param employee the employee expected to be a boss
     * @return <code>true</code> if the employee is a boss or <code>false</code> if not
     */
    @Override public boolean validate(Employee employee) {
        return employee.isBoss();
    }
}
