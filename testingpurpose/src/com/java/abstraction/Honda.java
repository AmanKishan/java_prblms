 package   com.java.abstraction;
import static java.lang.System.*; //static import

public class Honda extends Bike {

	

	
	@Override
	public void run() {
		
		Package p = Package.getPackage("com.java.abstraction");
		System.out.println(p.getName());

		out.println("bike is running !!");//no need to qualify the class name 
		// this thing is only work for static classed
		
	}

	public static void main(String[] args) {
		Bike b = new Honda();
		 b.run();
		 b.changeGear();
		 b.h.changeGear();
		 
		 
	}

	@Override
	public void changeGear() {

out.println("change gear!!");
		
	}


}