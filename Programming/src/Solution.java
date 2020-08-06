import java.util.*;

public class Solution {

    public static boolean canWin2(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i< game.length ; i++){
        	list.add(game[i]);
            if(leap == list.size()){
                 if(list.contains(0)){
                	 if(list.get(list.size()-1) == 0) {
                		 list.clear(); 
                	 }else {
                		 System.out.println(" list.lastIndexOf(0)" + list.lastIndexOf(0));
                		 list.subList(0, list.lastIndexOf(0)).clear() ;
                	 }
                     
                 }else {
                	 return false;
                 }
            }
        }
        return true;
    }

    
    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }
    
    static int getMaxLength(int arr[], int n) 
    { 
          
        int count = 0; //intitialize count 
        int result = 0; //initialize max 
      
        for (int i = 0; i < n; i++) 
        { 
              
            // Reset count when 0 is found 
            if (arr[i] == 0) 
                count = 0; 
      
            // If 1 is found, increment count 
            // and update result if count becomes 
            // more. 
            else
            { 
                count++;//increase count 
                result = Math.max(result, count); 
            } 
        } 
      
        return result; 
    } 
   
    public static boolean canWin(int leap, int[] game) {
    	int cnt = getMaxLength(game,game.length);
    	System.out.println(cnt + " < " + leap);
    	if(cnt < leap ) {
    		
    		return true; 
    	}else {
    		
    			return false;
    	}
    	
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)));
        }
        scan.close();
    }
}

