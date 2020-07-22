package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HappyFortuneService implements FortuneService {



    @Override
    public String getFortune() {
        return "You're blessed with luck!";
    }
}
