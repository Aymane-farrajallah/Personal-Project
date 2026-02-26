package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Exceptions.ProjectNotFoundException;
import projet.personalproject.Services.ProjectApplication.ProjectApplicationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectApplicationControllers {
    private ProjectApplicationService projectApplicationService;

    @PostMapping("/apply/{projectName}")
    public ProjectApplicationDTO applyProject(@PathVariable String projectName , @RequestBody ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException {
        return projectApplicationService.applyProjectApplication(projectName , projectApplicationDTO);
    }

    @GetMapping("/{projectName}/applications")
    public List<ProjectApplicationDTO> findByProjectName(@PathVariable String projectName) {
        return projectApplicationService.applicationsForProject(projectName);
    }

    @PutMapping("applications/state/{id}")
    public ProjectApplicationDTO acceptOrRejectProject(@PathVariable Integer id , @RequestBody ProjectApplicationDTO projectApplicationDTO) throws ProjectNotFoundException {
        projectApplicationDTO.setId(id);
        return projectApplicationService.acceptOrRejectApplication(id , projectApplicationDTO);
    }
}