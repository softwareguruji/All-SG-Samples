package example;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,2,3,4,5};
		int[][][] aCombinations = new int[a.length-1][2][];
		for (int i = 0; i < a.length-1; i++) {
			int[] b = new int[i+1];
			for(int j=0;j<=i;j++){
				b[j] = a[j];
			}
			System.out.println("b length"+b.length);
			aCombinations[i][0] = b; 
					
			int[] c = new int[a.length-b.length];
			for(int j=i+1, k=0;j<a.length;j++,k++){
				c[k] = a[j];
			}
			System.out.println("c length"+c.length);
			
			aCombinations[i][1] = c;
		}
		System.out.println(aCombinations);
	}

}
