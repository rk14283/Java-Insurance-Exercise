package com.example.insuranceplanupdated;

import static java.lang.Double.parseDouble;

public class PhoneInsurance extends Insurance {

    public PhoneInsurance(int purchasePrice) {
        super(purchasePrice, "phone insurance", 0.01);

        //double premium = Double.valueOf(purchasePrice)* 0.1;
        //int premium = purchasePrice* 5;
        //Premium(purchasePrice, 0.01);
        //Premium();




    }

    @Override
    public double CalculatePremium(int purchasePrice, double premium) {
        return super.CalculatePremium(purchasePrice, 0.01);
    }
}
