package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SolutionProgram2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String[] values = firstLine.split(" ");
        
        int[][] arr = new int[values.length][];
        for(int i=0; i<values.length; i++){
            String line = in.nextLine();
            String[] value = line.split(" ");
            int valArr[] = new int[value.length];
            int k = value.length-1;
            for(int j=0;j<value.length;j++){
                valArr[k--] = Integer.parseInt(value[j]);
            }
            arr[i] = valArr;
        }
        int totalOfEach[] = new int[arr.length];
        boolean allAreSame = false;
        do{
            for(int i=0; i<arr.length; i++){
                int currentTotal = 0;
                for(int j=0;j<arr[i].length;j++){
                    currentTotal += arr[i][j];
                }
                totalOfEach[i] = currentTotal;
            }
        
            int maxIndex = -1;
            for(int i=0; i<totalOfEach.length-1; i++){
                if(totalOfEach[i] < totalOfEach[i+1]){
                    maxIndex = i+1;
                }
                if(totalOfEach[i] > totalOfEach[i+1]){
                    maxIndex = i;
                }
            }
            
            if(maxIndex == -1){
                allAreSame = true;
            }else{
                //ArrayUtils.remove(arr[maxIndex],arr[maxIndex].length-1);
                //arr[maxIndex][arr[maxIndex].length-1] = 0;
            	arr[maxIndex] = removeElement(arr[maxIndex], arr[maxIndex].length-1);
            }
            
        }while(!allAreSame);
        
        System.out.println(totalOfEach[0]);
        /*for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        
    }
    
    public static int[] removeElement(int[] original, int element){
        int[] n = new int[original.length - 1];
        System.arraycopy(original, 0, n, 0, element );
        System.arraycopy(original, element+1, n, element, original.length - element-1);
        return n;
    }
}
