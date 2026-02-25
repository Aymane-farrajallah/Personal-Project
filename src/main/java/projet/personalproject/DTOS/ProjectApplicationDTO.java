package projet.personalproject.DTOS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Entities.Project;
import projet.personalproject.Entities.Student;
import projet.personalproject.Enums.State;

import java.util.Date;

@Data
public class ProjectApplicationDTO {
    public Integer id;
    @Enumerated(EnumType.STRING)
    public State state;
    public String projectName;
    public Date dateApplied;
}
