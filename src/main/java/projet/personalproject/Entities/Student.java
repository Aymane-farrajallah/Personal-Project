package projet.personalproject.Entities;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Users {
    public Department department;
}
