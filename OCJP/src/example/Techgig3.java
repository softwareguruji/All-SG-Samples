package example;

import java.util.HashSet;
import java.util.Set;

public class Techgig3 {

	
	public static void main(String[] args) throws Exception {
		/*int a[][] = 
			{
					{1,2,3},
					{4,5,6},
					{7,8,9}
			};*/
		
		/*int a[][] = 
			{
					{1,2,3,4},
					{3,4,1,2},
					{2,1,4,3},
					{4,3,2,1}
			};*/
		
		/*int a[][] = 
			{
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0}
			};*/
		
		/*int a[][] = 
			{
					{1,0,0,0},
					{0,0,2,0},
					{0,3,0,0},
					{0,0,0,4}
			};*/
		
		int a[][] = 
			{
					{1,2,3,0,0,0,0,0,0},
					{0,0,0,0,0,0,1,2,3},
					{0,0,0,1,2,3,0,0,0},
					{2,3,1,0,0,0,0,0,0},
					{0,0,0,0,0,0,2,3,1},
					{0,0,0,2,3,1,0,0,0},
					{3,1,2,0,0,0,0,0,0},
					{0,0,0,0,0,0,3,1,2},
					{0,0,0,3,1,2,0,0,0}
			};
		
		/*int a[][] = 
			{
					{1,2,3,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,1,2,3,1},
					{0,0,0,1,2,3,0,0,0,1},
					{2,3,1,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,2,3,1,1},
					{0,0,0,2,3,1,0,0,0,1},
					{3,1,2,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,3,1,2,1},
					{0,0,0,3,1,2,0,0,0,1},
					{0,0,0,3,1,2,0,0,0,1}
			};*/
		
		SolveMagicSquare(a);
	}
	
    public static int SolveMagicSquare(int[][] bigS) throws Exception
    {
    	//small square possiblities
    	int smallS = (int)Math.sqrt(bigS.length);
    	
    	//There is 1 in left upper cell
    	/*if(bigS[0][0] == 1){
    		return 0; //Condition 1
    	}*/
    	
    	//There are no repeating numbers in any rows
    	boolean check2 = test2(bigS);
    	//System.out.println(check2);
    	if(check2){
    		
    		//There are no repeating numbers in any columns
    		boolean check3 = test3(bigS);
    		//System.out.println(check3);
    		
    		if(check3){
    			//There are no repeating numbers in any small square blocks.
    			boolean check4 = test4(bigS,3);
    			//System.out.println(check4);
    			
    			if(check4){
    				return 1;
    			}
    		}
    	}
    	
    	return 0;
    }
    
    //There are no repeating numbers in any rows
    private static boolean test2(int[][] bigS){

    	for(int i=0; i<bigS.length; i++){
    		for(int j=0; j<bigS.length; j++){
    			for(int k=j+1; k<bigS.length; k++){
    				if(bigS[i][j] == bigS[i][k]){
    					if(bigS[i][j] != 0)
    						return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }

    private static boolean test3(int[][] bigS){

    	for(int i=0; i<bigS.length; i++){
    		for(int j=0; j<bigS.length; j++){
    			for(int k=j+1; k<bigS.length; k++){
    				if(bigS[j][i] == bigS[k][i]){
    					if(bigS[j][i] != 0)
    						return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }

    private static boolean test4(int[][] bigS, int smallS) throws Exception{
    	
    	if(bigS.length % smallS > 0){
    		throw new Exception("In compatible devision");
    	}
    	
    	int noOfRows = (int)(bigS.length / smallS);
    	
    	for(int i = 0; i < noOfRows; i++){
    		for (int j = 0; j < noOfRows; j++) {
				int[][] smallArr = getGroupByRowAndColIndex(bigS, smallS, i, j);
				Set<Integer> s = new HashSet<>();
				for (int k = 0; k < smallArr.length; k++) {
					for (int k2 = 0; k2 < smallArr.length; k2++) {
						if(s.add(smallArr[k][k2]) == false){
							if(smallArr[k][k2] != 0)
							return false;
						}
					}
				}
			}
    	}
    	
    	return true;
    }
    
    //This is to get group by row and column index for various checkings.
    private static int[][] getGroupByRowAndColIndex(int[][] bigS, int smallS, int requiredGroupRowIndex, int requiredGroupColIndex) throws Exception{
    	
    	//System.out.println(requiredGroupRowIndex+","+requiredGroupColIndex);
    	
    	if(bigS.length % smallS > 0){
    		throw new Exception("In compatible devision");
    	}
    	
    	int noOfRows = (int)(bigS.length / smallS);
    	
    	if(requiredGroupRowIndex < 0 || requiredGroupRowIndex>=noOfRows
    			|| requiredGroupColIndex < 0 || requiredGroupColIndex>=noOfRows){
    		throw new Exception("Improper required group");
    	}
    	
    	int returnArr[][] = new int[smallS][smallS];
    	
    	//int l=0;
    	for(int l=0; l<noOfRows; l++){
    	
    		//for row counting
    		int rowStPoint = l * smallS;

    		for(int k = 0; k<noOfRows; k++){
	    		//for column counting
	    		int colStPoint = k * smallS;
	    		int colEndPoint = colStPoint + smallS;
	    		
	    		if(l == requiredGroupRowIndex
	    				&& k == requiredGroupColIndex){
	    			
		    		//for (int i = stPoint; i < endPoint; i++){
		    		//System.out.println("<-- "+l+","+k+"-->");
		    		for (int i = rowStPoint,i1 = 0; i < rowStPoint + smallS; i++,i1++){
		    			for (int j = colStPoint, j1=0; j < colEndPoint; j++, j1++) {
		    				//System.out.print(bigS[i][j]+" ");
		    				returnArr[i1][j1] = bigS[i][j];
		    			}
		    			//System.out.println();
		    		}
	    		}
	    	}
    	}
    	
    	return returnArr;
    }
    
}
