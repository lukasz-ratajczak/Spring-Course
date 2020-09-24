package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("ID = "+student.getId());
            System.out.println("First name = "+student.getFirstName());
            System.out.println("Last name = "+student.getLastName());
            System.out.println("Active = "+student.isActive());
//            System.out.println("Address = "+ student.getAddress().getState() + " " +student.getAddress().getZip() + " " +student.getAddress().getCountry() + " " +
//                    student.getAddress().getCity() + " " +student.getAddress().getStreet());
            System.out.println("Address = "+student.getAddress().toString());
            System.out.println("Languages = "+ Arrays.toString(student.getLanguages()));

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
