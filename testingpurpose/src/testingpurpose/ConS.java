
package testingpurpose;
import com.lambhdaMethodRef.java.*;


public class ConS {
	static String str ;
	public ConS() {
	System.out.println("Heelo");
	str = "aman";
	}
	public static void main(String[] args) {
		
		try {
			System.out.println(amna(args));
		}
		catch(Exception e) {
			System.out.println("EXE");
		}
		amna(args);
		
	}
	
	static int amna(String [] args) {
		return Integer.parseInt(args[0]);
	}

}
