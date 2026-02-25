package projet.personalproject.Services.ProjectApplication;

import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Exceptions.ProjectNotFoundException;

public interface ProjectApplicationService {

    ProjectApplicationDTO applyProjectApplication(String ProjectName , ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException;
}
