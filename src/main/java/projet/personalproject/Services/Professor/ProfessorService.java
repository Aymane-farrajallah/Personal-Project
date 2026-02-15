package projet.personalproject.Services.Professor;

import projet.personalproject.DTOS.ProfessorDTO;
import projet.personalproject.Enums.Department;

public interface ProfessorService {
    public ProfessorDTO createProfessor(String Major , Department department);
}
