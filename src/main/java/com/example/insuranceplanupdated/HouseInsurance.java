package com.example.insuranceplanupdated;

public class HouseInsurance extends Insurance {
    public HouseInsurance(int purchasePrice) {
        super(purchasePrice, "house insurance",0.00025);

      //  Premium(purchasePrice, 0.00025);
        //this method is returning raw value
        //Premium();
    }
    @Override
    public double CalculatePremium(int purchasePrice, double premium) {
        return super.CalculatePremium(purchasePrice, 0.00025);
    }

}
