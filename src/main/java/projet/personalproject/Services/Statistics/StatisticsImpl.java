package projet.personalproject.Services.Statistics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.personalproject.Entities.Professor;
import projet.personalproject.Entities.ProjectApplication;
import projet.personalproject.Entities.Student;
import projet.personalproject.Entities.Users;
import projet.personalproject.Enums.State;
import projet.personalproject.Repositories.ProjectApplicationRepository;
import projet.personalproject.Repositories.ProjectRepository;
import projet.personalproject.Repositories.UsersRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StatisticsImpl implements StatisticsService {
    public ProjectRepository projectRepository;
    public UsersRepository usersRepository;
    public ProjectApplicationRepository projectApplicationRepository;

    @Override
    public Integer projectCount(){
        return projectRepository.findAll().size();
    }

    @Override
    public Integer studentCount(){
        int i =0;
        List<Users> users = usersRepository.findAll();

        for(Users user : users){
            if(user instanceof Student){
                i=i++;
            }
        }
        return i;
    }

    @Override
    public Integer ProfessorCount(){
        int i =0;
        List<Users> users = usersRepository.findAll();

        for(Users user : users){
            if(user instanceof Professor){
                i=i++;
            }
        }
        return i;
    }

    @Override
    public String acceptedVScanceled(){
        int accepted = 0;
        int canceled = 0;
        List<ProjectApplication> projectApplications = projectApplicationRepository.findAll();
        for(ProjectApplication projectApplication : projectApplications){
            if (projectApplication.getState() == State.Accepted){
                accepted=accepted+1;
            }else if (projectApplication.getState() == State.Canceled){
                canceled=canceled+1;
            }
        }
        return "Accepted Projects are : " + accepted + " and Canceled Projects are : " + canceled;
    }
}