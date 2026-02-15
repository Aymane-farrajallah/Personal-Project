package projet.personalproject.Services.Professor;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.Mappers.UserMappers;
import projet.personalproject.Repositories.UsersRepository;

@Service
@Transactional
@AllArgsConstructor
public class ProfessorImpl {
    private UsersRepository usersRepository;
    private UserMappers userMappers;
}
