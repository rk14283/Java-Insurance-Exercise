package com.example.insuranceplanupdated;

public class HouseInsurance extends Insurance {
    public HouseInsurance(int purchasePrice) {
        super(purchasePrice, "house insurance");

        Premium(purchasePrice, 0.00025);
    }
}
