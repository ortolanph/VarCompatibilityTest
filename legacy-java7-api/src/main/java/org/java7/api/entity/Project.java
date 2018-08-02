package org.java7.api.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The project entity.
 */
public class Project {

    private String name;

    private int businessCode;

    private int duration;

    private Set<ProgrammingLanguage> languages = new HashSet<>();

    private Set<Database> databases = new HashSet<>();

    private Set<Employee> team = new HashSet<>();

    /**
     * Builds a project from scratch.
     */
    public Project() {
    }

    /**
     * Builds a project with name, businessCode, and duration.
     *
     * @param name         the project name
     * @param businessCode the internal business code
     * @param duration     the project duration
     */
    public Project(String name, int businessCode, int duration) {
        this.name = name;
        this.businessCode = businessCode;
        this.duration = duration;
    }

    public void addProgrammingLanguage(ProgrammingLanguage language) {
        languages.add(language);
    }

    public void addDatabase(Database database) {
        databases.add(database);
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<ProgrammingLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<ProgrammingLanguage> languages) {
        this.languages = languages;
    }

    public Set<Database> getDatabases() {
        return databases;
    }

    public void setDatabases(Set<Database> databases) {
        this.databases = databases;
    }

    public Set<Employee> getTeam() {
        return team;
    }

    public void setTeam(Set<Employee> team) {
        this.team = team;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Project project = (Project) o;
        return businessCode == project.businessCode;
    }

    @Override public int hashCode() {
        return Objects.hash(businessCode);
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("name='").append(name).append('\'');
        sb.append(", businessCode=").append(businessCode);
        sb.append(", duration=").append(duration);
        sb.append(", languages=").append(languages);
        sb.append(", databases=").append(databases);
        sb.append(", team=").append(team);
        sb.append('}');
        return sb.toString();
    }
}
