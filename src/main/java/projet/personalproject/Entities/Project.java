package projet.personalproject.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import projet.personalproject.Enums.Domaine;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Project {

    @CreationTimestamp
    public Date date;
    @Id
    public String projectName;
    public String description;
    @Enumerated(EnumType.STRING)
    public Domaine domaine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    public Professor professor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public Student student;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "project")
    public List<ProjectApplication> projectApplication;
}