package projet.personalproject.DTOS;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import projet.personalproject.Enums.Department;

@Data
public class StudentDTO extends UsersDTO {
    @Enumerated(EnumType.STRING)
    public Department department;
    public String Major;
}
