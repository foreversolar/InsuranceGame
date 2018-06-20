package com.example.captain.work;

public class Protagonist {

    private String name;
    private int trust;
    private int charm;
    private int innovation;

    public Protagonist(String name,
                       int trust,
                       int charm,
                       int innovation){
        this.name = name;
        this.trust = trust;
        this.charm = charm;
        this.innovation = innovation;
    }


    //get attribute
    public String getName()
    {
        return name;
    }

    public int getTrust()
    {
        return trust;
    }
    public int getCharm()
    {
        return charm;
    }
    public int getInnovation()
    {
        return innovation;
    }

    //set attribute
    public void setName(String name){
        this.name = name;
    }
    public void setTrust(int trust){
        this.trust = trust;
    }
    public void setCharm(int charm){
        this.charm = charm;
    }
    public void setInnovation(int innovation){
        this.innovation = innovation;
    }
}
