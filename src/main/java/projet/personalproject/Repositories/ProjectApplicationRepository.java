package projet.personalproject.Repositories;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.personalproject.DTOS.ProjectApplicationDTO;
import projet.personalproject.Entities.Project;
import projet.personalproject.Entities.ProjectApplication;
import projet.personalproject.Enums.State;

import java.util.List;

public interface ProjectApplicationRepository extends JpaRepository<ProjectApplication, Integer> {

    List<ProjectApplication> findByProject_ProjectName(String ProjectName);
}