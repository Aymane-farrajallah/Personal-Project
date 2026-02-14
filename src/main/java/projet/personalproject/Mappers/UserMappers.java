package projet.personalproject.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Entities.Users;

@Service
public class UserMappers {
    public UsersDTO fromUser(Users users){
        UsersDTO usersDTO = new UsersDTO();
            BeanUtils.copyProperties(users,usersDTO);
        return usersDTO;
    }

    public Users fromUsersDTO(UsersDTO usersDTO){
        Users users = new Users();
            BeanUtils.copyProperties(usersDTO,users);
        return users;
    }
}
