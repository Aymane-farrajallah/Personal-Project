package projet.personalproject.Web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.personalproject.Services.Statistics.StatisticsService;

@RestController
@AllArgsConstructor
public class StatisticsControllers {
    private StatisticsService statisticsService;

    @GetMapping("/projects/count")
    public Integer projectCount(){
        return statisticsService.projectCount();
    }

    @GetMapping("/students/count")
    public Integer studentCount(){
        return statisticsService.studentCount();
    }

    @GetMapping("/professors/count")
    public Integer ProfessorCount(){
        return statisticsService.ProfessorCount();
    }

    @GetMapping("/acceptedvscanceled")
    public String acceptedVScanceled(){
        return statisticsService.acceptedVScanceled();
    }
}
