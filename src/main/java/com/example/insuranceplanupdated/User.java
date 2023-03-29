package com.example.insuranceplanupdated;

import java.util.ArrayList;
import java.util.Random;

public class User {
    public String email;
    public String name;
    public String IBAN;
    public int id;
    public ArrayList<Insurance> insurances;

    public User(String email, String name, String IBAN) {
        this.email = email;
        this.name = name;
        this.IBAN = IBAN;
        Random rand = new Random();
        this.id = rand.nextInt( 9000);
        insurances = new ArrayList<Insurance>();
    }
    public void addInsurance(Insurance insurance){
        this.insurances.add(insurance);
    }
}
