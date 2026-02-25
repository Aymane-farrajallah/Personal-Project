package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Exceptions.ProjectNotFoundException;
import projet.personalproject.Services.ProjectApplication.ProjectApplicationService;

@RestController
@AllArgsConstructor
public class ProjectApplicationControllers {
    private ProjectApplicationService projectApplicationService;

    @PostMapping("/apply/{projectName}")
    public ProjectApplicationDTO applyProject(@PathVariable String projectName , @RequestBody ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException {
        return projectApplicationService.applyProjectApplication(projectName , projectApplicationDTO);
    }
}