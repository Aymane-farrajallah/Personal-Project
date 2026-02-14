package projet.personalproject.DTOS;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import projet.personalproject.Enums.Sex;
import java.util.Date;

@Data
public class UsersDTO {
    public int id;
    public String lastName;
    public String firstName;
    @Email
    public String email;
    public String phoneNum;
    @Size(min = 8)
    public String password;
    public Sex sex;
    public Date birthdate;
}
