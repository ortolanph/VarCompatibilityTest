package org.java10.compatible.core;

import org.java7.api.entity.Employee;
import org.java7.api.entity.Project;
import org.java7.api.persistence.ProjectDAO;
import org.java8.utils.api.validators.impl.ProjectInstanceValidator;
import org.java9.module.business.ProjectController;

import java.util.Set;

import static org.java7.api.entity.Database.ORACLE;
import static org.java7.api.entity.Database.POSTGRESQL;
import static org.java7.api.entity.ProgrammingLanguage.*;

public class CompatibilityTest {

    private static final int EIGHT_MONTHS = 8;

    public static void main(String[] args) {
        var dao = new ProjectDAO();

        var project = new Project();

        project.setBusinessCode(1234);
        project.setDuration(EIGHT_MONTHS);
        project.setName("Project Valkyrie");

        var boss = new Employee() {

            private double salary;

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }
        };

        boss.setId(1);
        boss.setName("Big Boss");
        boss.setTieline(1000);
        boss.setBoss(true);
        boss.setSalary(1000000.00);

        var employee1 = Employee.buildAnEmployee(2, "Hard Worker", 1001);
        var employee2 = Employee.buildAnEmployee(3, "Soft Worker", 1002);

        var employees = Set.of(boss, employee1, employee2);
        var languages = Set.of(JAVA, JAVASCRIPT, PL_SQL);
        var databases = Set.of(ORACLE, POSTGRESQL);

        project.setTeam(employees);
        project.setLanguages(languages);
        project.setDatabases(databases);

        var controller = new ProjectController(dao);

        var instanceValidator = new ProjectInstanceValidator();

        System.out.println(instanceValidator.validate(project));
        System.out.println(project);

        var errors = controller.validateProject(project);

        System.out.println("Errors validating project");

        errors.forEach(System.out::println);
    }

}
