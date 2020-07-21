package com.luv2code.springdemo;

public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "score 50 goals";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
