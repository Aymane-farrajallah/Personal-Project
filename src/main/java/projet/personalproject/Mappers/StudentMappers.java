package projet.personalproject.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Entities.Student;

@Service
public class StudentMappers {

    public StudentDTO fromStudent(Student student){
        StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(student,studentDTO);
        return studentDTO;
    }
    public Student fromStudentDTO(StudentDTO studentDTO){
        Student student = new Student();
            BeanUtils.copyProperties(studentDTO,student);
        return student;
    }
}
