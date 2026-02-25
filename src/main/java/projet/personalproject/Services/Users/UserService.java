package projet.personalproject.Services.Users;

import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    UsersDTO getUser(Integer id) throws UserNotFoundException;

    List<UsersDTO> getUsers();

    UsersDTO updateUser(Integer id, UsersDTO dto);
}