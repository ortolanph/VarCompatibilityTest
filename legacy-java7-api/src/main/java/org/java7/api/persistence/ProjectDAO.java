package org.java7.api.persistence;

import org.java7.api.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 */
public class ProjectDAO {

    private static final ProjectDAO INSTANCE = new ProjectDAO();

    private List<Project> projects = new ArrayList<>();

    /**
     * Builds a ProjectDAO.
     */
    private ProjectDAO() {

    }

    /**
     * Returns the single instance of the ProjectDAO.
     *
     * @return  the single instance of the ProjectDAO.
     */
    private ProjectDAO getInstance() {
        return INSTANCE;
    }

    /**
     * Inserts a project.
     *
     * @param project the project to be inserted
     * @return <code>true</code> if the project has been inserted or <code>false</code> if not
     */
    public boolean insertProject(Project project) {
        return projects.add(project);
    }

    /**
     * Updates a project.
     *
     * @param project the project to be updated
     * @return the updated project
     */
    public Project updateProject(Project project) {
        Project oldProject = findProject(project.getBusinessCode());
        removeProject(oldProject);
        insertProject(project);
        return project;
    }

    /**
     * Finds a project by it's business code.
     *
     * @param businessCode the project business code
     * @return the desired project
     */
    public Project findProject(int businessCode) {
        for (Project project : allProjects()) {
            if (project.getBusinessCode() == businessCode) {
                return project;
            }
        }

        throw new NoSuchElementException();
    }

    /**
     * Deletes a project.
     *
     * @param project the project to be deleted
     * @return <code>true</code> if the project has been deleted or <code>false</code> if not
     */
    public boolean removeProject(Project project) {
        return projects.remove(project);
    }

    /**
     * Retrieve all projects.
     *
     * @return all projects.
     */
    public List<Project> allProjects() {
        return new ArrayList<>(projects);
    }

}
