package projet.personalproject.Entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "Pr")
public class Professor extends Users {
    public Department department;
}
