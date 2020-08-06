
public class TestInterfaceClass implements TestInterface , TestInterfaceOther{

	@Override
	public void testHello() {


	}
	
	@Override
	public void testDeafult() {
		// TODO Auto-generated method stub
		//TestInterfaceOther.super.testDeafult();
		//TestInterface.super.testDeafult();
		System.out.println("child test default");
	}

	/*@Override
	public void testDeafult(){
		System.out.println("hello default ovverriden");
	}*/
	
	public static void main(String[] args) {
		
		TestInterfaceClass t = new TestInterfaceClass();
		t.testDeafult();
		
		
		
	}

}
