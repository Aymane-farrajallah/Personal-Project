package projet.personalproject.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.personalproject.Enums.Sex;
import java.util.Date;


@Entity @AllArgsConstructor @NoArgsConstructor @Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Role" , length = 4)

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String lastName;
    public String firstName;
    @Email
    public String email;
    @Column(unique = true)
    public String phoneNum;
    @Size(min = 8)
    public String password;
    @Enumerated(EnumType.STRING)
    public Sex sex;
    public Date birthdate;
}
