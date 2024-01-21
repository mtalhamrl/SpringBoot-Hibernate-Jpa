package com.learningSpring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    public BaseBallCoach() {
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spring 30 minutes in practice";
    }
}
