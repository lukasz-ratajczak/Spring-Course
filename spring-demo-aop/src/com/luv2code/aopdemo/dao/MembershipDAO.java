package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSilly(){

        System.out.println(getClass()+": DOING MY STUFF WORK: ADD MEMBERSHIP ACCOUNT");

        return true;
    }
    public void goToSleep(){
        System.out.println(getClass()+": Goin' to sleep");
    }

}
