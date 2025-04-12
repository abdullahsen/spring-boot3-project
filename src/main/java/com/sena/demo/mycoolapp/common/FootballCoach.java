package com.sena.demo.mycoolapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Play football!";
    }
}
