package com.learningSpring.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrachCoach implements Coach{
    public TrachCoach() {
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "run a hard 5km";
    }
}
