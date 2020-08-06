import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	   public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	         Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        List<Integer> list = new ArrayList<>();
	        for(int i =0 ; i< n ; i++){
	               list.add(in.nextInt());
	        }

	        
	          int q_zero = in.nextInt();
	          for (int i = 0; i < q_zero; i++) {
	              String action = in.next();
	              if (action.equals("Insert")) {
	                  int index = in.nextInt();
	                  int value = in.nextInt();
	                  list.add(index, value);
	              } else { // "Delete"
	                  int index = in.nextInt();
	                  list.remove(index);
	              }
	          }
	          in.close();
	           list.forEach(ele -> System.out.print(ele + " "));
	    }
}
