package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.java8.utils.api.validators.Validator;

public class BossValidator implements Validator<Employee> {

    @Override public boolean validate(Employee employee) {
        return employee.isBoss();
    }
}
