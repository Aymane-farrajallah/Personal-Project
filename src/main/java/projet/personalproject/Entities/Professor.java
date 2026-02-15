package projet.personalproject.Entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "Pr")
public class Professor extends Users {
    public Department department;
    public String rank;
    @ManyToOne(cascade = CascadeType.ALL)
    public Student student;
}
