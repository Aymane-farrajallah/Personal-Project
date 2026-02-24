package projet.personalproject.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

import java.util.List;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@DiscriminatorValue(value = "St")
public class Student extends Users {
    @Enumerated(EnumType.STRING)
    public Department department;
    public String Major;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    public Professor professor;
    @OneToMany(mappedBy = "professor")
    public List<Project> project;
}
