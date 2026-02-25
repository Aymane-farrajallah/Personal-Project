package projet.personalproject.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Entities.ProjectApplication;

@Service
public class ProjectApplicationMappers {

    public ProjectApplicationDTO fromProjectApplication(ProjectApplication projectApplication){
        ProjectApplicationDTO projectApplicationDTO = new ProjectApplicationDTO();
            projectApplicationDTO.setId(projectApplication.getId());
            projectApplicationDTO.setProjectName(projectApplication.getProject().getProjectName());
            projectApplicationDTO.setState(projectApplication.getState());
            projectApplicationDTO.setDateApplied(projectApplication.getDateApplied());
        return projectApplicationDTO;
    }
    public ProjectApplication fromProjectApplicationDTO(ProjectApplicationDTO projectApplicationDTO){
        ProjectApplication projectApplication = new ProjectApplication();
            projectApplication.setId(projectApplicationDTO.getId());
            projectApplication.setState(projectApplicationDTO.getState());
            projectApplication.setDateApplied(projectApplicationDTO.getDateApplied());
        return projectApplication;
    }
}
