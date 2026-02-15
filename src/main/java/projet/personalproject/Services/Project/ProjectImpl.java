package projet.personalproject.Services.Project;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Entities.Project;
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
    public List<ProjectDTO> getProjects() {
        List<Project> project = projectRepository.findAll();
        List<ProjectDTO> projectDTO = new ArrayList<>();
        for (Project p : project) {
            projectDTO.add(projectMappers.fromProject(p));
        }
        return projectDTO;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO){
        Project project = projectMappers.fromProjectDTO(projectDTO);
        Project updatedProject = projectRepository.save(project);
        return projectMappers.fromProject(updatedProject);
    }

    @Override
    public void deleteProject(String projectName) throws  ProjectNotFoundException {
        Project project = projectRepository.findById(projectName).
                orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        projectRepository.delete(project);
    }
}