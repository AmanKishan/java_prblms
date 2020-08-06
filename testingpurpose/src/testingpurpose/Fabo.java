package testingpurpose;

public class Fabo {

	public int fabo(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return n;
		}else {
			int num= fabo(n)+fabo(n-1);
		}
		return n;
	}
	
	public static void main(String[] args) {

		
	}

}
