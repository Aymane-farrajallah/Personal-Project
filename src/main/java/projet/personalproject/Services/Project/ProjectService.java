package projet.personalproject.Services.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Enums.Domaine;
import projet.personalproject.Exceptions.ProjectNotFoundException;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    Page<ProjectDTO> getProjects(Integer pageNo ,  Integer pageSize);

    ProjectDTO getProjectByName(String projectName) throws ProjectNotFoundException;

    ProjectDTO updateProject(ProjectDTO projectDTO) throws ProjectNotFoundException;

    void deleteProject(String projectName) throws  ProjectNotFoundException;

    Page<ProjectDTO> searchProjects(Domaine domaine , int pageNo , int pageSize);
}
