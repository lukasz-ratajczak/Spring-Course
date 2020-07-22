package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

//    @Value("${rand.fortune}")
//    private String[] data;

    List<String> listOfLines = new ArrayList<>();

    private Random random = new Random();

    @PostConstruct
    public void doMyStartupStuff() throws IOException {
        System.out.println(">> HappyFortuneService: inside of doMyStartupStuff <<");
        BufferedReader abc = new BufferedReader(new FileReader("D:\\Coder\\Spring Course\\spring-demo-annotations\\src\\com\\luv2code\\springdemo\\fortunes.txt"));
        List<String> data = new ArrayList<String>();
        String s;
        while((s=abc.readLine())!=null) {
            data.add(s);
            System.out.println(s);
        }
        abc.close();
        listOfLines = data;
    }

    @Override
    public String getFortune() {
        int i = random.nextInt(listOfLines.size());
        return listOfLines.get(i);
    }
}

