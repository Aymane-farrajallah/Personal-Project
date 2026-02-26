package projet.personalproject.Services.ProjectApplication;

import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Exceptions.ProjectNotFoundException;

import java.util.List;

public interface ProjectApplicationService {

    ProjectApplicationDTO applyProjectApplication(String ProjectName , ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException;

    List<ProjectApplicationDTO> applicationsForProject(String ProjectName);

    ProjectApplicationDTO acceptOrRejectApplication(Integer id, ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException;
}
