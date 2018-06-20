package com.example.captain.work;
public class Consumer {
    String area;
    String age;
    String wealth;
    
    private static Consumer[] consumer=new Consumer[100];
    

    public Consumer() {}
    public Consumer(String area,String age,String wealth) {
    	this.area=area;
    	this.age=age;
    	this.wealth=wealth;
    }
    
    

    public static void initialization() {
//       consumer[0]=new Consumer("C��","����","С��");
//       consumer[1]=new Consumer("C��","����","С��");
//       consumer[2]=new Consumer("C��","����","С��");
//       consumer[3]=new Consumer("C��","����","С��");
       
       
    		   
    	
    
    }

    public boolean isConsumer(int standard) {
    	if(consumer[standard].area.equals(this.area)&&
    	   consumer[standard].age.equals(this.age)&&
    	   consumer[standard].wealth.equals(this.wealth)) {
    		return true;
    	}
    	else {
    	return false;
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
