package com.example.insuranceplanupdated;

public abstract class Insurance {
    public int purchasePrice;
    public String type;
    public double premium;

    public Insurance(int purchasePrice, String type,double premium) {
        this.purchasePrice = purchasePrice;
        this.type = type;
        this.premium= premium;
        //this.premium = premium;
        //this.premium = purchasePrice*premium;



    }
    public String toString(){
        return this.type + " " + this.purchasePrice;
    }
   public double calculatePremium() {
       //   return this.purchasePrice*premium;
      // return  premium * purchasePrice;
       double premiumEuro = this.purchasePrice*this.premium;
       return premiumEuro;
   }
}
