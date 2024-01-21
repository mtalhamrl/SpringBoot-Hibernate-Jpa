package com.learningSpring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrachCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "run a hard 5km";
    }
}
