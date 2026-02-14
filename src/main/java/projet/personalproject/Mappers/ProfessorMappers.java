package projet.personalproject.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Entities.Professor;

@Service
public class ProfessorMappers {
    public ProfessorDTO fromProfessor(Professor professor){
        ProfessorDTO professorDTO = new ProfessorDTO();
        BeanUtils.copyProperties(professor,professorDTO);
        return professorDTO;
    }
    public Professor fromProfessorDTO(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO,professor);
        return professor;
    }
}
