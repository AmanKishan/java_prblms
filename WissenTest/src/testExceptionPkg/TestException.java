package testExceptionPkg;

import java.io.IOException;

public class TestException {

	
	void m() throws IOException{  
	    throw new IOException("device error");//checked exception  
	  }  
	
	public static void main(String[] args) {
		try {
			System.out.println("hello");	
		}
		finally {
			System.out.println("hello");
		}
		try {
			int i = 5/4;
			System.out.println(i);
			throw new CustomException("custom exp");
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(CustomException e) {
			System.out.println("Here it is coming" + e.getMessage());
		}
		
		catch(Exception e) {
			System.out.println("main exp " + e.getMessage());
		}
		catch(Throwable e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			System.out.println("clean here");
		}
		
	}
	
}
