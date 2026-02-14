package projet.personalproject.Services;
import org.apache.catalina.User;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Mappers.UserMappers;
import projet.personalproject.Repositories.UsersRepository;

@AllArgsConstructor
@Slf4j
@Service
@Transactional
public class UsersImpl implements UsersServices {
    private UsersRepository usersRepository;
    private UserMappers userMappers;

    public UsersDTO saveUsers(UsersDTO usersDTO) {
        User user = userMappers.fromUsersDTO(usersDTO);
        User savedUser = usersRepository.save(user);
        return userMappers.fromUser(savedUser);
    };
}
