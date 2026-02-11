package projet.personalproject.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Domaine;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    public Date date;
    @Id
    public String projectName;
    public String description;
    public Domaine domaine;
}
