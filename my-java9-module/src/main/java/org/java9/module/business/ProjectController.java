package org.java9.module.business;

import org.java7.api.entity.Project;
import org.java7.api.persistence.ProjectDAO;
import org.java8.utils.api.validators.Validator;
import org.java8.utils.api.validators.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProjectController {

    List<Validator<Project>> validators =
        List.of(
            new ProjectNameValidator(),
            new BusinessCodeValidator(),
            new ProjectDurationValidator(),
            new ProgrammingLanguagesValidator(),
            new DatabasesValidator(),
            new TeamValidator(new BossValidator(), new EmployeeValidator()));

    List<String> messages =
        List.of(
            "Invalid project name",
            "Invalid business code",
            "Invalid project duration",
            "Insufficient programming languages",
            "Insufficient database platforms",
            "More than one boss or no employees");

    private ProjectDAO projectDAO;

    public ProjectController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public List<String> validateProject(Project project) {
        List<String> errorMessages = new ArrayList<>();

        IntStream
            .range(0, validators.size())
            .forEach(i -> {
                if (validators.get(i).validate(project)) {
                    errorMessages.add(messages.get(i));
                }
            });

        return messages;
    }

    public boolean insertNewProject(Project project) {
        return projectDAO.insertProject(project);
    }

    public Project updateProject(Project project) {
        return updateProject(project);
    }

    public Project findProject(int businessCode) {
        return projectDAO.findProject(businessCode);
    }

    public boolean removeProject(Project project) {
        return projectDAO.removeProject(project);
    }

    public List<Project> allProjects() {
        return projectDAO.allProjects();
    }
}
