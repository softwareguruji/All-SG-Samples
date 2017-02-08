package hackerrank.tut.thirtydayofcode;

import java.util.Scanner;

public class Day11 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        /*for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        int max = -10;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
            	//printOfHourGlass(i, j, arr);
            	int curSum = sumOfHourGlass(i, j, arr);
                //System.out.println("sum: "+curSum);
                max = Math.max(max, curSum);
            }
        }
        System.out.println(max);
	}

	public static int sumOfHourGlass(int indexX,int indexY, int[][] arr){
		int sum = 0;
		sum += arr[indexX][indexY]+arr[indexX][indexY+1]+arr[indexX][indexY+2];
		sum += arr[indexX+1][indexY+1];
		sum += arr[indexX+2][indexY]+arr[indexX+2][indexY+1]+arr[indexX+2][indexY+2];
		return sum;
	}
	
	public static void printOfHourGlass(int indexX,int indexY, int[][] arr){
		System.out.println(arr[indexX][indexY]+" "+arr[indexX+1][indexY]+" "+arr[indexX+2][indexY]);
		System.out.println("  "+arr[indexX+1][indexY+1]);
		System.out.println(arr[indexX][indexY+2]+" "+arr[indexX+1][indexY+2]+" "+arr[indexX+2][indexY+2]);
	}
}
