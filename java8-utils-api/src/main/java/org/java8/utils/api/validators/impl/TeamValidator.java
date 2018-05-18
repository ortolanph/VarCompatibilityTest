package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.java8.utils.api.validators.Validator;

import java.util.Set;

public class TeamValidator implements Validator<Set<Employee>> {

    @Override public boolean validate(Set<Employee> employees) {
        boolean hasOneBoss = employees.stream().filter(e -> e.isBoss()).count() == 1;
        boolean hasAtLeastOneEmployee = employees.stream().filter(e -> !e.isBoss()).count() >= 1;

        return hasOneBoss && hasAtLeastOneEmployee;
    }
}
