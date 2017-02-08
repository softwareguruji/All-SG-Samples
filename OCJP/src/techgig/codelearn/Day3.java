package techgig.codelearn;

import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double principle = sc.nextDouble();
		int interest = sc.nextInt();
		int year = sc.nextInt();
		
		int result = (int)((principle * interest * year)/100);
		System.out.println(result);
	}
}
