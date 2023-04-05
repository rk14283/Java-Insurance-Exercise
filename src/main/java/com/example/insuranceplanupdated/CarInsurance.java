package com.example.insuranceplanupdated;

public class CarInsurance extends Insurance {
    public CarInsurance(int purchasePrice) {
        super(purchasePrice, "car insurance",0.0015);
       // Premium(purchasePrice, 0.0015);
        //If I do not add premium method there is no premium cacluclation
        //now from this method how do I get
        //Premium();
    }

}
