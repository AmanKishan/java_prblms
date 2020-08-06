
public interface TestInterface {

	 String str = "aman";
	 
		
	abstract void  testHello();
	
	default void testDeafult(){
		
		System.out.println("hello default");
	}
	
static  void testStatic (){
		
		System.out.println("hello testStatic");
	}
}

