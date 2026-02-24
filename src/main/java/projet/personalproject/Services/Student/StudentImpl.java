package projet.personalproject.Services.Student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Entities.Student;
import projet.personalproject.Entities.Users;
import projet.personalproject.Mappers.StudentMappers;
import projet.personalproject.Repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentImpl implements StudentService {
    public UsersRepository usersRepository;
    public StudentMappers studentMappers;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        Student student = new Student();
        student.setLastName(studentDTO.getLastName());
        student.setFirstName(studentDTO.getFirstName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword());
        student.setMajor(studentDTO.getMajor());
        student.setSex(studentDTO.getSex());
        student.setBirthdate(studentDTO.getBirthdate());
        student.setPhoneNum(studentDTO.getPhoneNum());
        student.setDepartment(studentDTO.getDepartment());
        Student createdStudent = usersRepository.save(student);

        return studentMappers.fromStudent(createdStudent);
    }

    @Override
    public List<StudentDTO> getStudents(){
        List<Users> users = usersRepository.findAll();
        List<StudentDTO> studentDTO = new ArrayList<>();
        for(Users user : users){
            if(user instanceof Student student){
                studentDTO.add(studentMappers.fromStudent(student));
            }
        }
            return studentDTO;
        }
}