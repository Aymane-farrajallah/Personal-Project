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

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ProjectApplicationDTO> applicationsForProject(String ProjectName){
        List<ProjectApplicationDTO> projectApplicationDTOList = new ArrayList<>();
        List<ProjectApplication> projectAplicationList = projectApplicationRepository.findByProject_ProjectName(ProjectName);
        for(ProjectApplication projectApplication : projectAplicationList){
            projectApplicationDTOList.add(projectApplicationMappers.fromProjectApplication(projectApplication));
        }
        return projectApplicationDTOList;
    }

    @Override
    public ProjectApplicationDTO acceptOrRejectApplication(Integer id, ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException {
        ProjectApplication projectApplication1 = projectApplicationRepository.findById(id).
                orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        ProjectApplication projectApplication = projectApplicationMappers.fromProjectApplicationDTO(projectApplicationDTO);
        projectApplication.setProject(projectApplication1.getProject());
        ProjectApplication createdprojectApplication = projectApplicationRepository.save(projectApplication);
        return projectApplicationMappers.fromProjectApplication(createdprojectApplication);
    }
}