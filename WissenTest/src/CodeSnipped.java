
public class CodeSnipped {

	final int abc;

	{
		abc = 9;
		System.out.println(abc);
	}

	CodeSnipped() {
		//abc = 7;
		System.out.println(abc);
	}

	public static void main(String[] args) {
		CodeSnipped c = new CodeSnipped();
		
	}

}



