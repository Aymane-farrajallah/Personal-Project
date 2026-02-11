package projet.personalproject.DTOS;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import projet.personalproject.Enums.Sex;
import java.util.Date;

public class UsersDTO {
    public int id;
    public String lastName;
    public String firstName;
    @Email
    @NotBlank
    public String email;
    public String phoneNum;
    @Size(min = 6)
    public String password;
    public Sex sex;
    public Date birthdate;
}
