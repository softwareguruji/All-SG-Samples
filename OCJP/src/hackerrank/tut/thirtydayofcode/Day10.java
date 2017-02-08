package hackerrank.tut.thirtydayofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day10 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
		int n = 439;//in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(n>0){
            int reminder = n%2;
            n = n/2;
            list.add(reminder);
        }
        
        Collections.reverse(list);

        int max = 0;
        int _1counter = 0;
        for(int i: list){
            System.out.print(i+" ");
            if(i == 1){
            	_1counter++;
            	if(max < _1counter){
            		max = _1counter;
            	}
            }else{
            	if(max < _1counter){
            		max = _1counter;
            	}
            	_1counter = 0;
            }
            
            if(list.size() == _1counter){
            	max = _1counter;
            }
        }
        System.out.println();
        System.out.println(max);
	}
}
