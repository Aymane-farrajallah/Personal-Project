package projet.personalproject.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.ProjectDTO;
import projet.personalproject.Entities.Project;

@Service
public class ProjectMappers {

    public ProjectDTO fromProject(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
            BeanUtils.copyProperties(project,projectDTO);
        return projectDTO;
    }
    public Project fromProjectDTO(ProjectDTO projectDTO){
        Project project = new Project();
            BeanUtils.copyProperties(projectDTO,project);
        return project;
    }
}
