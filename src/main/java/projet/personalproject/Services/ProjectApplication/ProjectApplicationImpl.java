package projet.personalproject.Services.ProjectApplication;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Entities.Project;
import projet.personalproject.Entities.ProjectApplication;
import projet.personalproject.Exceptions.ProjectNotFoundException;
import projet.personalproject.Mappers.ProjectApplicationMappers;
import projet.personalproject.Repositories.ProjectApplicationRepository;
import projet.personalproject.Repositories.ProjectRepository;

@Service
@AllArgsConstructor
@Transactional
public class ProjectApplicationImpl implements ProjectApplicationService {
    public ProjectApplicationRepository projectApplicationRepository;
    public ProjectRepository projectRepository;
    public ProjectApplicationMappers  projectApplicationMappers;

    @Override
    public ProjectApplicationDTO applyProjectApplication(String ProjectName , ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException {
        Project project = projectRepository.findById(ProjectName).
                orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        ProjectApplication projectApplication = projectApplicationMappers.fromProjectApplicationDTO(projectApplicationDTO);
        projectApplication.setProject(project);
        ProjectApplication createdprojectApplication = projectApplicationRepository.save(projectApplication);
        return projectApplicationMappers.fromProjectApplication(createdprojectApplication);
    }
}