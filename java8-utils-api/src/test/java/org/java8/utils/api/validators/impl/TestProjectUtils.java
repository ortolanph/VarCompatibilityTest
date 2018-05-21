package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Database;
import org.java7.api.entity.Employee;
import org.java7.api.entity.ProgrammingLanguage;
import org.java7.api.entity.Project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestProjectUtils {

    private static final TestProjectUtils INSTANCE = new TestProjectUtils();

    private final String PROJECT_NAME = "Test Project";

    private final int PROJECT_BUSINESS_CODE = 5000;

    private final int PROJECT_DURATION = 6;

    private final Set<ProgrammingLanguage> PROJECT_LANGUAGES = new HashSet<>();

    private final Set<Database> PROJECT_DATABASES = new HashSet<>();

    private final Set<Employee> PROJECT_TEAM = new HashSet<>();

    private final Employee PROJECT_BOSS = Employee.buildABoss(1, "Big Boss", 1234);

    private final Employee PROJECT_EMPLOYEE = Employee.buildAnEmployee(2, "Little Employee", 1235);

    public static TestProjectUtils getInstance() {
        return INSTANCE;
    }

    public Employee boss() {
        return PROJECT_BOSS;
    }

    public Employee employee() {
        return PROJECT_EMPLOYEE;
    }

    public Project projectWithName(String name) {
        Project project = defaultProject();
        project.setName(name);
        return project;
    }

    public Project projectWithBusinessCode(int businessCode) {
        Project project = defaultProject();
        project.setBusinessCode(businessCode);
        return project;
    }

    public Project projectWithDuration(int duration) {
        Project project = defaultProject();
        project.setDuration(duration);
        return project;
    }

    public Project projectWithProgrammingLanguage(Set<ProgrammingLanguage> programmingLanguage) {
        Project project = defaultProject();
        project.setLanguages(programmingLanguage);
        return project;
    }

    public Project projectWithDatabase(Set<Database> databases) {
        Project project = defaultProject();
        project.setDatabases(databases);
        return project;
    }

    public Project projectWithTeam(Set<Employee> team) {
        Project project = defaultProject();
        project.setTeam(team);
        return project;
    }

    public Project defaultProject() {
        Project project = new Project();

        PROJECT_LANGUAGES.addAll(Arrays.asList(ProgrammingLanguage.values()));
        PROJECT_DATABASES.addAll(Arrays.asList(Database.values()));
        PROJECT_TEAM.add(PROJECT_BOSS);
        PROJECT_TEAM.add(PROJECT_EMPLOYEE);

        project.setName(PROJECT_NAME);
        project.setBusinessCode(PROJECT_BUSINESS_CODE);
        project.setDuration(PROJECT_DURATION);
        project.setLanguages(PROJECT_LANGUAGES);
        project.setDatabases(PROJECT_DATABASES);
        project.setTeam(PROJECT_TEAM);

        return project;
    }
}
