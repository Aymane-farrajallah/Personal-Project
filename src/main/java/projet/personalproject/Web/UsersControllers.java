package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.personalproject.DTOS.UsersDTO;
import projet.personalproject.Exceptions.UserNotFoundException;
import projet.personalproject.Mappers.UserMappers;
import projet.personalproject.Repositories.UsersRepository;
import projet.personalproject.Services.Users.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsersControllers {

    private UsersRepository usersRepository;
    private UserService userService;

    @GetMapping("/users")
    public List<UsersDTO> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        usersRepository.deleteById(id);
    }

    @GetMapping("/user/{id}")
    public UsersDTO getUser(@PathVariable Integer id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public UsersDTO updateUser(@PathVariable Integer id , @RequestBody UsersDTO usersDTO){
        usersDTO.setId(id);
        return userService.updateUser(id , usersDTO);
    }
}