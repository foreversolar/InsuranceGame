package com.example.captain.work.Employees;

public class Employees {
    private String Job;
    private String Name;
    private int Loyalty;
    private int Innovation;
    private int Intelligence;
    private int Sales;
    private int Management;
    private int Salary;
    private int SumStaff;
    private String intro;

    public Employees(
                     String job,
                     String name,
                     int loyalty,
                     int innovation,
                     int intelligence,
                     int sales,
                     int management,
                     int salary,
                     int sumStaff){
        Job = job;
        Name = name;
        Loyalty = loyalty;
        Innovation = innovation;
        Intelligence = intelligence;
        Sales = sales;
        Management = management;
        Salary = salary;
        SumStaff = sumStaff;
    }
    public Employees(String name,String sumstaff,int salary){
                         Name=name;
                         intro=sumstaff;
                         Salary=salary;

    }

    //change attribute
    public void changeLoyalty(int value){
        Loyalty += value;
    }
    public void changeInnovation(int value){
        Innovation += value;
    }
    public void changeIntelligence(int value){
        Intelligence += value;
    }
    public void changeSales(int value){
        Sales += value;
    }
    public void changeManagement(int value){
        Management += value;
    }
    public void changeSalary(int value){
        Salary += value;
    }
    public void addSumStaff(int value){
        SumStaff += value;
    }
    public void decreaseSumStaff(int value){
        SumStaff -= value;
    }
    public void setName(String name){
        Name = name;
    }
    // get attribute
    public String getJob()
    {
        return Job;
    }
    public String getName(){
        return Name;
    }
    public int getLoyalty()
    {
        return Loyalty;
    }
    public int getInnovation()
    {
        return Innovation;
    }
    public int getSales()
    {
        return Sales;
    }
    public int getManagement()
    {
        return Management;
    }
    public int getSalary()
    {
        return Salary;
    }
    public int getSumStaff()
    {
        return SumStaff;
    }
    public int getIntelligence(){
        return Intelligence;
    }

    @Override
//    public String toString() {
//        return "Name: " + Name + "Job" + Job + "Loyalty: " + Loyalty + "Innovation: " +
//                Innovation + "Intelligence: " + Intelligence +"Sales Skill: "
//                + Sales + "Management Skill: " + Management + "Salary: " + Salary;
//    }
    public String toString(){
        return Name+": "+intro+", 预计薪酬"+Salary;
    }
}
