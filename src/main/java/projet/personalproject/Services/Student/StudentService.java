package projet.personalproject.Services.Student;

import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Enums.Department;

public interface StudentService {
    StudentDTO createStudent(String Major, Department department);
}
