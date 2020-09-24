package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);

            System.out.println("ID = "+student.getId());
            System.out.println("First name = "+student.getFirstName());
            System.out.println("Last name = "+student.getLastName());
            System.out.println("Active = "+student.isActive());

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
