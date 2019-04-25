//https://www.techgig.com/codegladiators/question/ODk3MEAjJEAjJDE3Nzk2OTlAIyRAIyQ0NjM2OTE5QCMkQCMkMTQ5NTA3OTkyMQ==/1
package techgig.codegladiator.practice;

public class ChessKingHorseProblem2 {

	public static void main(String[] args) {
		
		//Case 1
		/*
		int x1 = 2;
		int y1 = 1;
		int x2 = 6;
		int y2 = 5;*/
		
		//Case 2
		int x1 = 7;
		int y1 = 7;
		int x2 = 2;
		int y2 = 2;
		System.out.println(getStepCount(x1, y1, x2, y2));
	}
	
	public static int getStepCount(int x1, int y1, int x2, int y2){
		
		System.out.println("("+x1+","+y1+")");
		int moveCounter = 0;
		while(!(x1 == x2 && y1 == y2)){
			try{
				if(x1 < x2){
					if(y1 < y2){
						if(x2 - x1 == 1 && y2 - y1 == 1){
							int temp[] = moveTL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 2 && y2 - y1 == 1){
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 3 && y2 - y1 == 1){
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 1 && y2 - y1 == 2){
							int temp[] = moveTR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else if(y1 > y2){
						if(x2 - x1 == 1 && y1 - y2 == 1){
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 2 && y1 - y2 == 1){
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 3 && y1 - y2 == 1){
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 1 && y1 - y2 == 2){
							int temp[] = moveBR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else if(y1 == y2){
						if(x2 - x1 == 1){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 2){
							int temp[] = moveBR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x2 - x1 == 3){
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}
				}else if(x1 == x2){
					if(y1 < y2){
						if(y2 - y1 == 1){
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else if(y2 - y1 == 2){
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else if(y2 - y1 == 3){
							int temp[] = moveTL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else{
							int temp[] = moveTL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else if(y1 > y2){
						if(y1 - y2 == 1){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else if(y1 - y2 == 2){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else if(y1 - y2 == 3){
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else{
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}
					//No any case of x1 == x2 along with y1 == y2. If it is problem already resolved.
				}else if(x1 > x2){
					if(y1 < y2){
						if(x1 - x2 == 1 && y2 - y1 == 1){
							int temp[] = moveTR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 2 && y2 - y1 == 1){
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 3 && y2 - y1 == 1){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 1 && y2 - y1 == 2){
							int temp[] = moveTL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else if(y1 > y2){
						if(x1 - x2 == 1 && y1 - y2 == 1){
							int temp[] = moveBR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 2 && y1 - y2 == 1){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 3 && y1 - y2 == 1){
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 1 && y1 - y2 == 2){
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else if(y1 == y2){
						if(x1 - x2 == 1){
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 2){
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else if(x1 - x2 == 3){
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}else{
							int temp[] = moveLD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}
				}
			}catch(Exception e){
				//Need to work here.
				e.printStackTrace();
				
				if(e.getMessage().endsWith("RD")){
					try {
						int temp[] = moveTL(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					} catch (Exception e1) {
						try {
							int temp[] = moveTR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else if(e.getMessage().endsWith("LD")){
					try {
						int temp[] = moveRU(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;						
					} catch (Exception e1) {
						try {
							int temp[] = moveRD(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;						
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else if(e.getMessage().endsWith("TL")){
					try {
						int temp[] = moveBR(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					} catch (Exception e1) {
						try {
							int temp[] = moveBL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else if(e.getMessage().endsWith("TR")){
					try {
						int temp[] = moveBL(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					} catch (Exception e1) {
						try {
							int temp[] = moveBR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else if(e.getMessage().endsWith("BL")){
					try {
						int temp[] = moveTR(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					} catch (Exception e1) {
						try {
							int temp[] = moveTL(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else if(e.getMessage().endsWith("BR")){
					try {
						int temp[] = moveTL(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					} catch (Exception e1) {
						try {
							int temp[] = moveTR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						} catch (Exception e2) {
							e1.printStackTrace();
						}
					}
				}else{
					break;
				}
			}
		}
		
		return moveCounter;
	}
	
	public static void printMove(int[] x){
		System.out.println("("+x[0]+","+x[1]+")");
	}
	
	//Move Top Left
	public static int[] moveTL(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-1;
		newX[1] = y+2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:TL");
		
		printMove(newX);
		return newX;
	}
	
	//Move Top Right
	public static int[] moveTR(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+1;
		newX[1] = y+2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:TR");
		
		printMove(newX);
		return newX;
	}
	
	//Move Bottom Left
	public static int[] moveBL(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-1;
		newX[1] = y-2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:BL");
		
		printMove(newX);
		return newX;
	}
	
	//Move Bottom Right
	public static int[] moveBR(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+1;
		newX[1] = y-2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:BR");
		
		printMove(newX);
		return newX;
	}
	
	//Move Left Up
	public static int[] moveLU(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-2;
		newX[1] = y+1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:LU");
		
		printMove(newX);
		return newX;
	}
	
	//Move Left Down
	public static int[] moveLD(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-2;
		newX[1] = y-1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:LD");
		
		printMove(newX);
		return newX;
	}
	
	//Move Right Up
	public static int[] moveRU(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+2;
		newX[1] = y+1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:RU");
		
		printMove(newX);
		return newX;
	}
	
	//Move Right Down
	public static int[] moveRD(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+2;
		newX[1] = y-1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move:RD");
		
		printMove(newX);
		return newX;
	}

}
