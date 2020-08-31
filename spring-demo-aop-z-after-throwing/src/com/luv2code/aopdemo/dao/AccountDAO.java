package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass()+": DOING MY DB WORK: ADD ACCOUNT");
    }

    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }


        List<Account> myAccounts = new ArrayList<>();

        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Mahdu", "Platinum");
        Account account3 = new Account("Luca", "Gold");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }

    public boolean doWork(){
        System.out.println(getClass()+": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
