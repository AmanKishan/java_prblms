import java.util.HashMap;
import java.util.Map;

public class TestPerson {

	public static void main(String[] args) {

		Map<Person, Integer> map = new HashMap<>();
		Person p1 = new Person();
		p1.setName("alok");

		Person p2 = new Person();
		p2.setName("alok");

		map.put(p1, 1);
		map.put(p2, 2);

		System.out.println(map);

		Person p3 = new Person();
		p3.setName("alok");
		System.out.println(map.get(p3));

	}

}
