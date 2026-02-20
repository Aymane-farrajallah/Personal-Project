package projet.personalproject.Services.Users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Entities.Student;
import projet.personalproject.Entities.Users;
import projet.personalproject.Exceptions.UserNotFoundException;
import projet.personalproject.Mappers.ProfessorMappers;
import projet.personalproject.Mappers.StudentMappers;
import projet.personalproject.Mappers.UserMappers;
import projet.personalproject.Repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<UsersDTO> getUsers(){
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> usersDTO = new ArrayList<>();
        for(Users user : users){
            usersDTO.add(userMappers.fromUser(user));
        }
        return usersDTO;
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        Users user = usersRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User Not Found for Delete"));
        usersRepository.delete(user);
    }

    public UsersDTO updateUser(Integer id, UsersDTO dto) {

        Users existing = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setId(dto.getId());
        existing.setFirstName(dto.getFirstName());
        existing.setBirthdate(dto.getBirthdate());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPassword(dto.getPassword());
        existing.setPhoneNum(dto.getPhoneNum());

        if (existing instanceof Student student && dto instanceof StudentDTO studentDTO) {
            student.setDepartment(studentDTO.getDepartment());
            student.setMajor(studentDTO.getMajor());
        }

        if (existing instanceof Professor professor && dto instanceof ProfessorDTO professorDTO) {
            professor.setDepartment(professorDTO.getDepartment());
            professor.setProfessor_rank(professorDTO.getProfessor_rank());
        }

        return userMappers.fromUser(usersRepository.save(existing));
    }
}