package com.learningSpring.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "practice your backhand volley";
    }
}
