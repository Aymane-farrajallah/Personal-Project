package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projet.personalproject.DTOS.StudentDTO;
import projet.personalproject.Services.Student.StudentService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentControllers {
    private StudentService studentService;

    @PostMapping("add-student")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents(){
        return studentService.getStudents();
    }
}
