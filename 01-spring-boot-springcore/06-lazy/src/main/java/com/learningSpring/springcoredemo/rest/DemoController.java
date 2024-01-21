package com.learningSpring.springcoredemo.rest;

import com.learningSpring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // defina a private field for the dependency
    private Coach coach;
//qualifier has higher priority
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach)
    {
        System.out.println("in constructor: "+ getClass().getSimpleName());
        coach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
