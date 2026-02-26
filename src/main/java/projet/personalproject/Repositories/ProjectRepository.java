package projet.personalproject.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import projet.personalproject.Entities.Project;
import projet.personalproject.Enums.Domaine;

import org.springframework.data.domain.Page;


public interface ProjectRepository extends JpaRepository<Project, String> {

    Page<Project> findByDomaine(Domaine domaine , Pageable pageable);
}
