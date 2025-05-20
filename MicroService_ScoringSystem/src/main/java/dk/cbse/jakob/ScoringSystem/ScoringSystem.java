package dk.cbse.jakob.ScoringSystem;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoringSystem{
    private int Score = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @GetMapping("/ScoringSystem")
    public int CalculateHealth(@RequestParam(value = "points", defaultValue = "World") int point){
        Score += point;
        return Score;
    }
// to access the site insert this URL: http://localhost:8080/ScoringSystem?points= insert amount of points
}