package projet.personalproject.Services.Project;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Entities.Project;
import projet.personalproject.Enums.Domaine;
import projet.personalproject.Exceptions.ProjectNotFoundException;
import projet.personalproject.Mappers.ProjectMappers;
import projet.personalproject.Repositories.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProjectImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private ProjectMappers projectMappers;

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO){
        Project project = projectMappers.fromProjectDTO(projectDTO);
        Project createdProject = projectRepository.save(project);
        return projectMappers.fromProject(createdProject);
    }

    @Override
    public Page<ProjectDTO> getProjects(Integer pageNo ,  Integer pageSize) {
        Page<ProjectDTO> projects = projectRepository.findAll(PageRequest.of(pageNo, pageSize))
                .map(project -> projectMappers.fromProject(project));
        return projects;
    }

    @Override
    public ProjectDTO getProjectByName(String projectName) throws ProjectNotFoundException{
        Project project = projectRepository.findById(projectName).
                orElseThrow(()-> new ProjectNotFoundException("Project not found"));
        return projectMappers.fromProject(project);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        Project project = projectMappers.fromProjectDTO(projectDTO);
        Project createdProject = projectRepository.save(project);
        return projectMappers.fromProject(createdProject);
    }

    @Override
    public void deleteProject(String projectName) throws  ProjectNotFoundException {
        Project project = projectRepository.findById(projectName).
                orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        projectRepository.delete(project);
    }

    @Override
    public Page<ProjectDTO> searchProjects(Domaine domaine , int pageNo , int pageSize) {

        Page<ProjectDTO> projects = projectRepository.findByDomaine(domaine , PageRequest.of(pageNo, pageSize))
                .map(project -> projectMappers.fromProject(project));

        return projects;
    }
}