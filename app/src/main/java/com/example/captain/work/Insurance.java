package com.example.captain.work;

import android.util.Log;

import java.util.Random;

public class Insurance {

	private String name;
	private int price;
	private double profitrate;
	private double agencyfeerate;
	private int besttype;
	private int bettertype;
	private int basicsales;
	private int sales;
	private int randomnumber;
	// private Insurance[] ins=new Insurance[100];
	private int inscount;
	Consumer cons = new Consumer();
	private boolean isexplored=false;
	private boolean issold=false;

	static private Insurance[] ins=new Insurance[4];

	public Insurance(String name, int price, double profitrate, double agencyfeerate) {
		this.name = name;
		this.price = price;
		this.profitrate = profitrate;
		this.agencyfeerate = agencyfeerate;

	}

	public  Insurance[] Initialize( ) {

		Insurance EndowmentIns = new Insurance("养老险",5000,0.009,0.0045);//养老险
		Insurance CarIns = new Insurance("车险",2000,0.009,0.0045);//车险
		Insurance BareIns = new Insurance("秃头险",5000,0.009,0.0045);//秃头险
		Insurance lifeIns = new Insurance("人身意外险",10000,0.009,0.0045);//人身意外险

		ins[0] = EndowmentIns;
		ins[1] = CarIns;
		ins[2] = BareIns;
		ins[3] = lifeIns;

		return ins;
	}

   /* public void setAttribute(String Name,
                             int Price,
                             double ProfitRate,
                             double AgencyFeeRate,
                             Consumer playChoosed){
        name = Name;
        price = Price;
        profitrate = ProfitRate;
        agencyfeerate = AgencyFeeRate;
        sales = processSales(playChoosed);
    }*/



	public Insurance() {
	}


	public  int agencyfee (String name){
		Log.d("item", "agenc: "+name);
		Initialize( );
		int fee=0;
		if (name.equals("")){return 0;}
		for(int i=0;i<ins.length;i++){
			if(name.equals(ins[i].name)){
				fee=(int)(ins[i].agencyfeerate*ins[i].price);
			}
		}

		return fee;


	}


	public int calcuAddtion() {
		return 1;
	}

	public int processSales(Consumer playchoosed) {
		int basicsale;
		if(playchoosed.isConsumer(besttype)) {
			basicsale=this.basicsales;
		}
		else if(playchoosed.isConsumer(bettertype)) {
			basicsale=this.basicsales/4;
		}
		else {
			basicsale=this.basicsales/10;
		}
		int additionResult=this.calcuAddtion();
		int randomnumber=this.randomnumber;
		Random random=new Random();
		int sales = basicsale+(additionResult*random.nextInt(randomnumber));

		return sales;
	}


    /*public String getname() {
        return this.name;
    }

    public void addInsurance(Insurance in) {
        ins[inscount]=in;
        inscount++;
    }

    public Insurance[] getallinsurance() {
        return this.ins;
    }*/

	public static void main(String[] args) {

	}


}
