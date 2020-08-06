import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestHashCollection {

	public static void main(String[] args) {
		
		Integer a = 16;
		
		Map<String,String> map = new HashMap<>();
		System.out.println(map.put(null,"aman"));
		System.out.println(map.put("hello", "aman"));
		System.out.println(map.put("hello", "akash"));
		System.out.println(map.put(null, "akash"));
		System.out.println(map.put(null, null));
		System.out.println(map.put(null, "hello"));
		
		System.out.println(map.get(null));
		
		
		Hashtable<String,String> hashTable = new Hashtable<>();
		hashTable.put("aman", "aman");
		System.out.println(hashTable.put("aman", "hhh"));
		
		
		String bb = "aman";
		String aa = new String("aman");
		String dd = aa.intern();
		System.out.println(aa == bb);
		System.out.println(dd == bb);
		
		
	}
}
