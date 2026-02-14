package projet.personalproject.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.personalproject.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
