package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    @Value("${rand.fortune}")
    private String[] data;

    private Random random = new Random();

    @Override
    public String getFortune() {
        int i = random.nextInt(data.length);
        return data[i];
    }
}
