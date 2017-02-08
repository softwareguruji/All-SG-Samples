package techgig.codelearn;

import java.util.Scanner;

public class Day2 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			try{
				Integer.parseInt(s);
				System.out.println("This input is of type Integer.");
			}catch(Exception e){
				try{
				Float.parseFloat(s);
				System.out.println("This input is of type Float.");
				}catch(Exception e1){
					System.out.println("This input is of type string.");
				}
			}
		}
	}
}
