package projet.personalproject.Services.Professor;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Entities.Users;
import projet.personalproject.Enums.Department;
import projet.personalproject.Mappers.ProfessorMappers;
import projet.personalproject.Repositories.UsersRepository;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class ProfessorImpl implements ProfessorService {
    private UsersRepository usersRepository;
    private ProfessorMappers professorMappers;

    @Override
    public ProfessorDTO createProfessor(String Rank , Department department) {
        Professor professor = new Professor();
            professor.setId((int) (Math.random() * 9000));
            professor.setFirstName(professor.getFirstName());
            professor.setLastName(professor.getLastName());
            professor.setEmail(professor.getEmail());
            professor.setPassword(professor.getPassword());
            professor.setDepartment(department);
            professor.setRank(Rank);
            Professor createdProfessor = usersRepository.save(professor);
        return professorMappers.fromProfessor(createdProfessor);
    }
}
