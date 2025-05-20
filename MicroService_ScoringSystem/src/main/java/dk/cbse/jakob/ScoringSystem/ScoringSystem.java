package dk.cbse.jakob.ScoringSystem;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoringSystem{
    private Long Score = 0L;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @GetMapping("/Score")
    public Long CalculateHealth(@RequestParam(value = "points") Long point){
        Score += point;
        return Score;
    }
// to access the site insert this URL: http://localhost:8080/Score?points= insert amount of points
}