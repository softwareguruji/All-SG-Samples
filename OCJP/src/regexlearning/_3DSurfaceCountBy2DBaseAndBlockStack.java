package regexlearning;

public class _3DSurfaceCountBy2DBaseAndBlockStack {

	public static void main(String[] args) {
		int[][] a = new int[3][3];
		a[0][0] = 1;
		a[1][0] = 3;
		a[2][0] = 4;
		a[0][1] = 2;
		a[1][1] = 2;
		a[2][1] = 3;
		a[0][2] = 1;
		a[1][2] = 2;
		a[2][2] = 4;
		
		int iMax = a.length;
		int jMax = a[0].length;
		
		int surfaceCounter = 0;
		for(int i=0; i<iMax; i++){
			for(int j=0; j<jMax; j++){
				if(i-1 < 0){
					surfaceCounter += a[i][j];
				}
				if(j-1 < 0){
					surfaceCounter += a[i][j];
				}
				if(i+1 >= iMax){
					surfaceCounter += a[i][j];
				}
				if(j+1 >= jMax){
					surfaceCounter += a[i][j];
				}
				
				if(i-1 >= 0 && a[i-1][j] < a[i][j]){
					surfaceCounter += (a[i][j] - a[i-1][j]);
				}
				
				if(i-1 >= 0 && a[i-1][j] > a[i][j]){
					surfaceCounter += (a[i-1][j] - a[i][j]);
				}
				
				if(j-1 >= 0 && a[i][j-1] < a[i][j]){
					surfaceCounter += (a[i][j] - a[i][j-1]);
				}
				
				if(j-1 >= 0 && a[i][j-1] > a[i][j]){
					surfaceCounter += (a[i][j-1] - a[i][j]);
				}
				
				//For Bottom
				surfaceCounter++;
				
				//For Top
				surfaceCounter++;
			}
		}
		System.out.println(surfaceCounter);
	}

}
