package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        Random random = new Random();
        int i = random.nextInt(3);
        String[] fortuneArray = {"Today is your lucky day!", "You Rule!", "Nice"};
        return fortuneArray[i];
    }
}
