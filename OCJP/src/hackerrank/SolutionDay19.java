package hackerrank;

public class SolutionDay19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		int n = 6;
		sum += 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                sum += i;
                System.out.print(i + " , ");
            }
        }
        sum += n;
		System.out.println(sum);
	}

}
