//https://www.techgig.com/codegladiators/question/ODk3MEAjJEAjJDE3Nzk2OTlAIyRAIyQ0NjM2OTE5QCMkQCMkMTQ5NTA3OTkyMQ==/1
package techgig.codegladiator.practice;

public class ChessKingHorseProblem {

	public static void main(String[] args) {
		
		//Case 1
		/*
		int x1 = 2;
		int y1 = 1;
		int x2 = 6;
		int y2 = 5;*/
		
		//Case 2
		int x1 = 6;
		int y1 = 6;
		int x2 = 5;
		int y2 = 5;
		System.out.println(getStepCount(x1, y1, x2, y2));
	}
	
	public static int getStepCount(int x1, int y1, int x2, int y2){
		
		System.out.println("("+x1+","+y1+")");
		int moveCounter = 0;
		while(!(x1 == x2 && y1 == y2)){
			try{
				if(x1 < x2){
					if(y1 < y2){
						int temp[] = moveRU(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					}else{
						int temp[] = moveRD(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					}
				}else if(x1 == x2){
					if(y1 < y2){
						if(y2 - y1 == 2){
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else{
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else{
						int temp[] = moveRD(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					}
				}else if(x1 > x2){
					if(y1 < y2){
						if(y2 - y1 == 1){
							int temp[] = moveLU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else{
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}if(y1 > y2){
						if(y1 - y2 == 1){
							int temp[] = moveBR(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;							
						}else{
							int temp[] = moveRU(x1, y1);
							x1 = temp[0];
							y1 = temp[1];
							moveCounter++;
						}
					}else{
						int temp[] = moveRD(x1, y1);
						x1 = temp[0];
						y1 = temp[1];
						moveCounter++;
					}
				}
			}catch(Exception e){
				//Need to work here.
				e.printStackTrace();
				break;
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
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Top Right
	public static int[] moveTR(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+1;
		newX[1] = y+2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Bottom Left
	public static int[] moveBL(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-1;
		newX[1] = y-2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Bottom Right
	public static int[] moveBR(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+1;
		newX[1] = y-2;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Left Up
	public static int[] moveLU(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-2;
		newX[1] = y+1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Left Down
	public static int[] moveLD(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x-2;
		newX[1] = y-1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Right Up
	public static int[] moveRU(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+2;
		newX[1] = y+1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}
	
	//Move Right Down
	public static int[] moveRD(int x, int y) throws Exception{
		int newX[] = new int[2];
		newX[0] = x+2;
		newX[1] = y-1;
		
		if(newX[0] < 1 || newX[0] > 8 || newX[1] < 1 || newX[1] > 8)
			throw new Exception("Invalid Move");
		
		printMove(newX);
		return newX;
	}

}
