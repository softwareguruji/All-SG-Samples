package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SolutionProgram2_2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        String[] values = firstLine.split(" ");
        
        for(int i=0; i<values.length; i++){
            String line = in.nextLine();
            String[] value = line.split(" ");
            ArrayList<Integer> data = new ArrayList<Integer>();
            for(int j=0;j<value.length;j++){
                data.add(Integer.parseInt(value[j]));
            }
            Collections.reverse(data);
            arr.add(data);
        }
        int totalOfEach[] = new int[arr.size()];
        boolean allAreSame = false;
        do{
            int maxIndex = -1;

            if(maxIndex == -1)
        	for(int i=0; i<arr.size(); i++){
                int currentTotal = 0;
                for(int j=0;j<arr.get(i).size();j++){
                    currentTotal += arr.get(i).get(j);
                }
                totalOfEach[i] = currentTotal;
            }
            
        
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
            	totalOfEach[maxIndex] = totalOfEach[maxIndex] - arr.get(maxIndex).get(arr.get(maxIndex).size()-1);
            	arr.get(maxIndex).remove(arr.get(maxIndex).size()-1);
            }
            
        }while(!allAreSame);
        System.out.println(totalOfEach[0]);
    }
}
