package projet.personalproject.Services.Student;

import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Enums.Department;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents();
}
