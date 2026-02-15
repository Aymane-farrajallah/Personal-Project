package projet.personalproject.Services.Users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Entities.Student;
import projet.personalproject.Entities.Users;
import projet.personalproject.Exceptions.UserNotFoundException;
import projet.personalproject.Mappers.ProfessorMappers;
import projet.personalproject.Mappers.StudentMappers;
import projet.personalproject.Mappers.UserMappers;
import projet.personalproject.Repositories.UsersRepository;

@Service
@Transactional
@AllArgsConstructor
public class UserImpl implements UserService {
    public UsersRepository usersRepository;
    public UserMappers userMappers;
    public StudentMappers studentMappers;
    public ProfessorMappers professorMappers;

    @Override
    public UsersDTO getUser(Integer id) throws UserNotFoundException {
        Users users = usersRepository.findById(id).
                orElseThrow(()->new UserNotFoundException("User Not Found"));

        if(users instanceof Professor){
            Professor professor = (Professor) users;
            return professorMappers.fromProfessor(professor);
        }else{
            Student student = (Student) users;
            return studentMappers.fromStudent(student);
        }
    }
}