package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Mappers.ProfessorMappers;
import projet.personalproject.Repositories.UsersRepository;
import projet.personalproject.Services.Professor.ProfessorService;

@RestController
@AllArgsConstructor
public class ProfessorControllers {
    private ProfessorService professorService;
    private UsersRepository usersRepository;
    private ProfessorMappers professorMappers;

    @PostMapping("add-prof")
    public ProfessorDTO addProf(@RequestBody ProfessorDTO professorDTO){
        return professorService.createProfessor(professorDTO);
    }
}
