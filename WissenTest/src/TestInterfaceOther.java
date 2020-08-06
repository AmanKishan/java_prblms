
public interface TestInterfaceOther {

	String str = "aman";
	abstract void testHello();
	
	default void testDeafult(){
		
		System.out.println("hello default other");
	}
	
static  void testStatic (){
		
		System.out.println("hello testStatic other");
	}
}
