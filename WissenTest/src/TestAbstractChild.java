
public class TestAbstractChild extends TestAbstraction {

	
	public TestAbstractChild() {
		
	}
	public TestAbstractChild(int a ) {
		super(a);
	System.out.println("hello child" + a);
	}
	public static void main(String[] args) {
	
		TestAbstraction t = new TestAbstractChild();
		TestAbstraction t1 = new TestAbstractChild(10);
		t1.send();
		t1.send("send methos");
		
	}
	@Override
	void send(String message) {
		
		System.out.println(message);
	}
	
	
}
