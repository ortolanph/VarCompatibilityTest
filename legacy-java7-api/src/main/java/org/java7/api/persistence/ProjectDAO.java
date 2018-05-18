package org.java7.api.persistence;

import org.java7.api.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProjectDAO {

    private static final ProjectDAO INSTANCE = new ProjectDAO();

    private List<Project> projects = new ArrayList<>();

    private ProjectDAO getInstance() {
        return INSTANCE;
    }

    public boolean insertProject(Project project) {
        return projects.add(project);
    }

    public Project updateProject(Project project) {
        Project oldProject = findProject(project.getBusinessCode());
        removeProject(oldProject);
        insertProject(project);
        return project;
    }

    public Project findProject(int businessCode) {
        for (Project project : allProjects()) {
            if (project.getBusinessCode() == businessCode) {
                return project;
            }
        }

        throw new NoSuchElementException();
    }

    public boolean removeProject(Project project) {
        return projects.remove(project);
    }

    public List<Project> allProjects() {
        return new ArrayList<>(projects);
    }

}
