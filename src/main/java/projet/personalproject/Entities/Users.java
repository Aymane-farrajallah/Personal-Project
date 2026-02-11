package projet.personalproject.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Sex;
import java.util.Date;


@Entity @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String lastName;
    public String firstName;
    public String email;
    @Column(unique = true)
    public String phoneNum;
    public String password;
    public Sex sex;
    public Date birthdate;
}
