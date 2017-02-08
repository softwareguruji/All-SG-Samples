package hackerrank.contest.weekofcode21;

public class Contest1_1 {

	public static void main(String[] args) {
		int startPositionA = 0;
		int incrementA = 3;
		int startPositionB = 4;
		int incrementB = 2;
		
		int currentPositionA = startPositionA;
		int currentPositionB = startPositionB;
		int counter = 0;
		
		do{
			currentPositionB = currentPositionB + incrementB;
			currentPositionA = currentPositionA + incrementA;
			counter++;
			
			if(counter > 100){
				break;
			}
			
			System.out.println(currentPositionA + " : "+ currentPositionB);
		}while(currentPositionA != currentPositionB);
		
		System.out.println(currentPositionA);
		if(counter > 100){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
	}
}
