package com.example.captain.work.Customer;

public class Customer{
    private int difficultyOfSales;
    private int profits;
    private String name;

    public Customer(
            String name,
            int difficultyOfSales,
            int profits
                    ){
        this.difficultyOfSales = difficultyOfSales;
        this.profits = profits;
        this.name = name;
    }

    //get attribute
    public int getDifficultyOfSales(){
        return difficultyOfSales;
    }
    public int getProfits(){
        return profits;
    }
    public String getName() {
        return name;
    }

}
