package projet.personalproject.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Department;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "Pr")
public class Professor extends Users {
    @Enumerated(EnumType.STRING)
    public Department department;
    public String Professor_rank;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    public List<Student> student;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    public List<Project>  project;
}
