package projet.personalproject.Services.Professor;

import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Exceptions.ProfessorNotFoundException;

public interface ProfessorService {
    ProfessorDTO createProfessor(ProfessorDTO professorDTO);
}