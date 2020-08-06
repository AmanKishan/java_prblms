import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(in.hasNextLine()) in.nextLine();
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

			while (in.hasNextLine()) {
				n = n -1;
				ArrayList<String> d = new ArrayList<String>();
				String[] line = in.nextLine().trim().split(" ");
				for (int j=0; j<line.length; j++) {
		               d.add(line[j]);
		            }
				System.out.println("d " + d);
				matrix.add(d);
				if(n ==0 ) break;
			}
			
		
		System.out.println("matrix " + matrix);
		int q = in.nextInt();
		//if(in.hasNextLine()) in.nextLine();
		System.out.println("q" + q);
		for (int i = 0; i < q; i++) {
			System.out.println("----");
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			System.out.println("a b " + a + " " + b);
			if(matrix.size() > a) {
				if(matrix.get(a).size() > b) {
					System.out.println(matrix.get(a).get(b));		
				}else {
					System.out.println("ERROR!");	
				}
			}else {
				System.out.println("ERROR!");
			}
			
			
		}
		in.close();
	}
}
