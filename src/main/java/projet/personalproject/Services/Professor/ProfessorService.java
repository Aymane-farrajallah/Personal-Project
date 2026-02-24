package projet.personalproject.Services.Professor;

import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Exceptions.ProfessorNotFoundException;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO createProfessor(ProfessorDTO professorDTO);

    List<ProfessorDTO> getAllProfessor();
}