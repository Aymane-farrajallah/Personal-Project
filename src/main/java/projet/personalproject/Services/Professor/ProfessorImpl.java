package projet.personalproject.Services.Professor;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Entities.Users;
import projet.personalproject.Mappers.ProfessorMappers;
import projet.personalproject.Repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class ProfessorImpl implements ProfessorService {
    private UsersRepository usersRepository;
    private ProfessorMappers professorMappers;

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
            professor.setFirstName(professorDTO.getFirstName());
            professor.setLastName(professorDTO.getLastName());
            professor.setEmail(professorDTO.getEmail());
            professor.setPassword(professorDTO.getPassword());
            professor.setDepartment(professorDTO.getDepartment());
            professor.setSex(professorDTO.getSex());
            professor.setBirthdate(professorDTO.getBirthdate());
            professor.setPhoneNum(professorDTO.getPhoneNum());
            professor.setProfessor_rank(professorDTO.getProfessor_rank());
            Professor createdProfessor = usersRepository.save(professor);
        return professorMappers.fromProfessor(createdProfessor);
    }

    @Override
    public List<ProfessorDTO> getAllProfessor() {
        List<Users> users = usersRepository.findAll();
        List<ProfessorDTO> professorDTOS = new ArrayList<>();

        for (Users user : users) {
            if (user instanceof Professor professor) {
                professorDTOS.add(professorMappers.fromProfessor(professor));
            }
        }
        return professorDTOS;
    }
}
