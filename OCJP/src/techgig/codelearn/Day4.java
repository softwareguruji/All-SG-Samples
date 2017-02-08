package techgig.codelearn;

import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		if(age < 10){
			System.out.println("I am happy as having no responsibilities.");
		}else if(age >= 10 && age < 18){
			System.out.println("I am still happy but starts feeling pressure of life.");
		}else if(age >= 18){
			System.out.println("I am very much happy as i handled the pressure very well.");
		}
	}

}
