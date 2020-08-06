
public class StringCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "84aedd82e87711d0e0635b7badb46a181842019059776";
		System.out.println(str.length());
		
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = new String("abc");
		String str4 = "abc";
	
		
		System.out.println(str1 == str2);
		System.out.println(str3 == str2);
		System.out.println(str1 == str4);
		
		
		
	}

}
