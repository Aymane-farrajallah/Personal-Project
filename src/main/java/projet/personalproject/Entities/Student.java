package projet.personalproject.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@DiscriminatorValue(value = "St")
public class Student extends Users {
    public Department department;
    public String Major;
    @ManyToOne(cascade = CascadeType.ALL)
    public Professor professor;
}
