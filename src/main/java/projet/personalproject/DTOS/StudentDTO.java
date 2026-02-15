package projet.personalproject.DTOS;
import lombok.Data;
import projet.personalproject.Enums.Department;

@Data
public class StudentDTO extends UsersDTO {
    public Department department;
    public String Major;
}
