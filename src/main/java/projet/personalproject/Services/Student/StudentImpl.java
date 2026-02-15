package projet.personalproject.Services.Student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Entities.Student;
import projet.personalproject.Enums.Department;
import projet.personalproject.Mappers.StudentMappers;
import projet.personalproject.Repositories.UsersRepository;

@Service
@Transactional
@AllArgsConstructor
public class StudentImpl implements StudentService {
    public UsersRepository usersRepository;
    public StudentMappers studentMappers;

    @Override
    public StudentDTO createStudent(String Major, Department department) {

        Student student = new Student();
        student.setId((int)(Math.random()*100));
        student.setLastName(student.getLastName());
        student.setFirstName(student.getFirstName());
        student.setEmail(student.getEmail());
        student.setPassword(student.getPassword());
        student.setMajor(Major);
        student.setDepartment(department);
        Student createdStudent = usersRepository.save(student);

        return studentMappers.fromStudent(createdStudent);
    }
}