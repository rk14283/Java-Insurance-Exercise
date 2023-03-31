package com.example.insuranceplanupdated;

public class CarInsurance extends Insurance {
    public CarInsurance(int purchasePrice) {
        super(purchasePrice, "car insurance");
        Premium(purchasePrice, 0.0015);
    }
}
