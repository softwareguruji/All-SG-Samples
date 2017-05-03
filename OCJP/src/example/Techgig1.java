package example;

public class Techgig1 {

	
	public static void main(String[] args) {
		System.out.println(GetJumpCount(4, 1, new int[]{6,9,11,4,5}));
	}
	
	public static int GetJumpCount(int canJump,int slipOnJump,int[] listOfWallsWithHight)
    {
	    //Write code here
	    
	    int jumpCounter = 0;
	    
	    for(int i=0; i<listOfWallsWithHight.length; i++){
	         int a = canJump;
	         jumpCounter++;
	         
	         if(a >= listOfWallsWithHight[i]){
	             //continue;
	         }else{
	             //for(int a = a + (canjump - slipOnJump); j<)
	             do{
	                 a = a + (canJump - slipOnJump);
	                 jumpCounter++;
	             }while(a < listOfWallsWithHight[i]);
	         }
	         System.out.println("["+i+"]: "+listOfWallsWithHight[i]+" :"+jumpCounter);
	    }
	    
	    return jumpCounter;
    }

}
