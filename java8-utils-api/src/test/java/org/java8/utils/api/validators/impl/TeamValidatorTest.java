package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.java7.api.entity.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TeamValidatorTest {

    private BossValidator bossValidator = new BossValidator();

    private EmployeeValidator employeeValidator = new EmployeeValidator();

    private TeamValidator teamValidator = new TeamValidator(bossValidator, employeeValidator);

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    private Set<Employee> TEAM_NO_EMPLOYEE = new HashSet<>();

    private Set<Employee> TEAM_WITH_ONE_BOSS = new HashSet<>();

    private Set<Employee> TEAM_WITH_ONE_EMPLOYEE = new HashSet<>();

    private Set<Employee> TEAM_COMPLETE = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        TEAM_WITH_ONE_BOSS.add(utils.boss());

        TEAM_WITH_ONE_EMPLOYEE.add(utils.employee());

        TEAM_COMPLETE.add(utils.boss());
        TEAM_COMPLETE.add(utils.employee());
    }

    @Test
    public void noEmployeeTeam() throws Exception {
        Project project = utils.projectWithTeam(TEAM_NO_EMPLOYEE);
        assertFalse(teamValidator.validate(project));
    }

    @Test
    public void bossOnlyTeam() throws Exception {
        Project project = utils.projectWithTeam(TEAM_WITH_ONE_BOSS);
        assertFalse(teamValidator.validate(project));
    }

    @Test
    public void employeeOnlyTeam() throws Exception {
        Project project = utils.projectWithTeam(TEAM_WITH_ONE_EMPLOYEE);
        assertFalse(teamValidator.validate(project));
    }

    @Test
    public void completeTeam() throws Exception {
        Project project = utils.projectWithTeam(TEAM_COMPLETE);
        assertTrue(teamValidator.validate(project));
    }
}
