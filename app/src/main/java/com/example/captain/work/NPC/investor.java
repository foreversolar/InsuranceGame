package com.example.captain.work.NPC;
public class investor {
    private int amountOfMoney;
    private int dueTime;
    private double interests;
    private double stockRight;

    public investor(
            int amountOfMoney,
            int dueTime,
            double interests,
            double stockRight){
        this.amountOfMoney = amountOfMoney;
        this.dueTime = dueTime;
        this.interests = interests;
        this.stockRight = stockRight;
    }

    //get attribute
    public int getAmountOfMoney(){
        return amountOfMoney;
    }
    public int getDueTime(){
        return dueTime;
    }
    public double getInterests(){
        return interests;
    }
    public double getStockRight(){
        return stockRight;
    }
}
