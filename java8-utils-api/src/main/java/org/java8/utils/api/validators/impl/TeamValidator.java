package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

public class TeamValidator implements Validator<Project> {

    private BossValidator bossValidator;

    private EmployeeValidator employeeValidator;

    public TeamValidator(BossValidator bossValidator, EmployeeValidator employeeValidator) {
        this.bossValidator = bossValidator;
        this.employeeValidator = employeeValidator;
    }

    @Override public boolean validate(Project project) {
        boolean hasOneBoss = project
            .getTeam()
            .stream()
            .filter(e -> bossValidator.validate(e))
            .count() == 1;

        boolean hasAtLeastOneEmployee = project
            .getTeam()
            .stream()
            .filter(e -> employeeValidator.validate(e))
            .count() >= 1;

        return !hasOneBoss && !hasAtLeastOneEmployee;
    }
}
