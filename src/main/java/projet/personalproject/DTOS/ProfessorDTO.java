package projet.personalproject.DTOS;
import lombok.Data;
import projet.personalproject.Enums.Department;

@Data
public class ProfessorDTO extends UsersDTO {
    public Department department;
    public String rank;
}
