package org.java9.module.business;

import org.java7.api.entity.Project;
import org.java7.api.persistence.ProjectDAO;
import org.java8.utils.api.validators.Validator;
import org.java8.utils.api.validators.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Business layer for projects.
 */
public class ProjectController {

    /** List of all Validators */
    List<Validator<Project>> validators =
        List.of(
            new NameValidator(),
            new BusinessCodeValidator(),
            new DurationValidator(),
            new ProgrammingLanguagesValidator(),
            new DatabasesValidator(),
            new TeamValidator(new BossValidator(), new EmployeeValidator()));

    /** Validators messages */
    List<String> messages =
        List.of(
            "Invalid project name",
            "Invalid business code",
            "Invalid project duration",
            "Insufficient programming languages",
            "Insufficient database platforms",
            "More than one boss or no employees");

    private ProjectDAO projectDAO;

    /**
     * Builds the project business layer from scratch.
     *
     * @param projectDAO the project persistence layer
     */
    public ProjectController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    /**
     * Validates a project.
     *
     * @param project the project to be validated
     * @return a message list telling what's wrong
     */
    public List<String> validateProject(Project project) {
        List<String> errorMessages = new ArrayList<>();

        for (int i = 0; i < validators.size(); i++) {
            Validator validator = validators.get(i);

            if (!validator.validate(project)) {
                errorMessages.add(messages.get(i));
            }
        }

        return errorMessages;
    }

    /**
     * Insert a new project.
     *
     * @param project the project to be inserted.
     * @return <code>true</code> if the project has been successfully inserted or <code>false</code> if not
     */
    public boolean insertNewProject(Project project) {
        return projectDAO.insertProject(project);
    }

    /**
     * Update a project.
     *
     * @param project the project to be updated.
     * @return the updated project
     */
    public Project updateProject(Project project) {
        return updateProject(project);
    }

    /**
     * Find a project.
     *
     * @param businessCode the business code
     * @return a project found by it's business code or <code>null</code>
     */
    public Project findProject(int businessCode) {
        return projectDAO.findProject(businessCode);
    }

    /**
     * Delete a project.
     *
     * @param project the project to be deleted
     * @return <code>true</code> if the project was deleted or <code>false</code> if not
     */
    public boolean removeProject(Project project) {
        return projectDAO.removeProject(project);
    }

    /**
     * Retrieve all projects.
     *
     * @return all projects
     */
    public List<Project> allProjects() {
        return projectDAO.allProjects();
    }
}
