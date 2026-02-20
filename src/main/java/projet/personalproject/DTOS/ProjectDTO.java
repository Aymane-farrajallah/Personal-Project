package projet.personalproject.DTOS;

import lombok.Data;
import projet.personalproject.Enums.Domaine;

import java.util.Date;

@Data
public class ProjectDTO {
    public Date date;
    public String projectName;
    public String description;
    public Domaine domaine;
}
