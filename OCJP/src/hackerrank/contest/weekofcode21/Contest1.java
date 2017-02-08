package hackerrank.contest.weekofcode21;

public class Contest1 {

	public static void main(String[] args) {
		int startPositionA = 0;
		int incrementA = 3;
		int startPositionB = 4;
		int incrementB = 2;
		
		int currentPositionA = startPositionA;
		int currentPositionB = startPositionB;
		
		int counterA = 0;
		int counterB = 0;
		
		do{
			if(currentPositionA > currentPositionB){
				currentPositionB = currentPositionB + incrementB;
				counterA++;
			}else{
				currentPositionA = currentPositionA + incrementA;
				counterB++;
			}
			System.out.println(currentPositionA + " : "+ currentPositionB);
		}while(currentPositionA != currentPositionB);
		
		System.out.println(currentPositionA);
		System.out.println(counterA + " :: " +counterB);
		if(counterA == counterB){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
	}
}
