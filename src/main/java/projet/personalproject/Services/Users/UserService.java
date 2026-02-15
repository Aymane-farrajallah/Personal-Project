package projet.personalproject.Services.Users;

import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Exceptions.UserNotFoundException;

public interface UserService {
    UsersDTO getUser(Integer id) throws UserNotFoundException;
}
