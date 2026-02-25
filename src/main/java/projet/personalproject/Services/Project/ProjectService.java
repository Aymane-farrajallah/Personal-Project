package projet.personalproject.Services.Project;

import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Exceptions.ProjectNotFoundException;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    List<ProjectDTO> getProjects();

    ProjectDTO getProjectByName(String projectName) throws ProjectNotFoundException;

    ProjectDTO updateProject(ProjectDTO projectDTO) throws ProjectNotFoundException;

    void deleteProject(String projectName) throws  ProjectNotFoundException;
}
