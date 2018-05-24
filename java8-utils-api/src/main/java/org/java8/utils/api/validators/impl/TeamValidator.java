package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Project;
import org.java8.utils.api.validators.Validator;

/**
 * Validates if the project team has at last one boss and one employee.
 */
public class TeamValidator implements Validator<Project> {

    private BossValidator bossValidator;

    private EmployeeValidator employeeValidator;

    /**
     * Builds a TeamValidator instance.
     *
     * @param bossValidator a BossValidator instance
     * @param employeeValidator a EmployeeValidator instance
     * @see BossValidator
     * @see EmployeeValidator
     */
    public TeamValidator(BossValidator bossValidator, EmployeeValidator employeeValidator) {
        this.bossValidator = bossValidator;
        this.employeeValidator = employeeValidator;
    }

    /**
     * Validates if the project team has at last one boss and one employee.
     *
     * @param project the project
     * @return <code>true</code> if the project team has at last one boss and one employee and <code>false</code> if not
     */
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

        return hasOneBoss && hasAtLeastOneEmployee;
    }
}
