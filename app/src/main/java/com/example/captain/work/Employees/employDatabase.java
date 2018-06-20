package com.example.captain.work.Employees;

public class employDatabase {

    public Employees[] Initialize( ) {

        Employees[] ins=new Employees[10];

        ins[0] = new Employees("张三","985金融本科生",9000);
        ins[1] = new Employees("李四","985计算机本科生",10000);
        ins[2] = new Employees("旺旺","双一流经济本科生",9000);
        ins[3] = new Employees("喵喵","双流公管本科生",8000);
        ins[4] = new Employees("哞哞","211金融硕士生",7800);;
        ins[5] = new Employees("叽叽","中传艺术本科生",7000);
        ins[6] = new Employees("渣渣","985金融本科生",9000);;
        ins[7] = new Employees("拉拉","985软件本科生",10000);
        ins[8] = new Employees("丁丁","211经济硕士生",8000);
        ins[9] = new Employees("波波","双一流金融本科生",9000);

        return ins;
    }


}
