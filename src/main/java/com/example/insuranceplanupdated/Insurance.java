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
   public double CalculatePremium(int purchasePrice, double premium) {
       //   return this.purchasePrice*premium;
      // return  premium * purchasePrice;
       this.premium = purchasePrice*premium;
       return this.premium;
   }
}
