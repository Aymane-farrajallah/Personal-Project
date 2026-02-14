package projet.personalproject.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.personalproject.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
}
