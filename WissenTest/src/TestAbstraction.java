
public abstract class TestAbstraction {

	public  TestAbstraction() {
		System.out.println("hello");
	}
	
	public TestAbstraction(int a){
		System.out.println("hello" + a);
	}
	
	  // Convenience method to send an empty message
    final void send() {
        send(null);
    }

    // Implementations should only implement this method
    abstract void send(String message);
}
