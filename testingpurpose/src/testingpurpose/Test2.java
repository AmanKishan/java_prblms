package testingpurpose;


class Bank{

	Integer ff =9;
	int ii= 9;
	final int speedlimit;
	
	public Bank() {
		speedlimit =100; 
	}
	
	public void aman(int a) {
		if(ff==ii) {
			System.out.println("int aman");	
		}
		
	}
	
	public void aman(String s) {
		System.out.println("String aman");
	}
	 
int getRateOfInterest(){return 0;}
}


class SBI extends Bank{
int getRateOfInterest(){return 8;}
}

class ICICI extends Bank{
int getRateOfInterest(){return 7;}
}
class AXIS extends Bank{
//int getRateOfInterest(){return 9;}
}

class Test2{
public static void main(String args[]){
SBI s=new SBI();
ICICI i=new ICICI();
Bank a=new AXIS();

Bank g=new Bank();
g.aman(1);

System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());
System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());
System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());

}


}
