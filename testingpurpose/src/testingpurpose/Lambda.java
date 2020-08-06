package testingpurpose;

import java.util.function.Predicate;

/**
 * @author aman_rastogi
 *
 */
public class Lambda {

	public static void main(String[] args) {
		
		Predicate<Integer> pred = x -> x %2 ==0;
		boolean result = pred.test(5);
		System.out.println(result);

	}

}
