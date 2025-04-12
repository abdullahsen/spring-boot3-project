package com.sena.demo.mycoolapp.rest;

import com.sena.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class FunRestController {

    @Value("${developer.name}")
    private String developerName;

    @Value("${developer.team}")
    private String developerTeam;

    private final Coach tennisCoach;

    private Coach footballCoach;

    @Autowired
    public FunRestController(@Qualifier("tennisCoach") Coach coach) {
        tennisCoach = coach;
        System.out.println("Constructor " + getClass().getSimpleName());
    }

    @Autowired
    public void setFootballCoach(@Qualifier("footballCoach") Coach footballCoach) {
        this.footballCoach = footballCoach;
    }

    @GetMapping()
    public String sayHello() {
        return "Hello " + developerName + "! You are from  " + developerTeam;
    }

    @GetMapping("/tennisdailyworkout")
    public String getTennisDailyWorkout() {
        return tennisCoach.getDailyWorkout();
    }

    @GetMapping("/footballdailyworkout")
    public String getFootballDailyWorkout() {
        return footballCoach.getDailyWorkout();
    }


}
