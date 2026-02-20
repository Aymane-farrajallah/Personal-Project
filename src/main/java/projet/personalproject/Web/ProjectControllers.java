package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Entities.Project;
import projet.personalproject.Exceptions.ProjectNotFoundException;
import projet.personalproject.Services.Project.ProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectControllers {
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<ProjectDTO> projects(){
        return projectService.getProjects();
    }

    @GetMapping("/project/{projectName}")
    public ProjectDTO getprojectById(@PathVariable String projectName) throws ProjectNotFoundException {
        return projectService.getProjectByName(projectName);
    }

    @DeleteMapping("/project/{projectName}")
    public void deleteCustomer(@PathVariable String projectName) throws ProjectNotFoundException {
        projectService.deleteProject(projectName);
    }

    @PostMapping("/add-project")
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @PutMapping("/project/{projectName}")
    public ProjectDTO updateProject(@PathVariable String projectName , @RequestBody ProjectDTO projectDTO) throws ProjectNotFoundException {
            projectDTO.setProjectName(projectName);
            return projectService.updateProject(projectDTO);
    }
}