package hackerearth.practice.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = null;
        String line2 = null;
        String line3 = null;
        
        int matchTo = -1;
		try {
			line1 = br.readLine();
			line2 = br.readLine();
			line3 = br.readLine();
			matchTo = Integer.parseInt(line3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] sp = line2.split(" ");
		
		boolean isMatched = false;
		for(String s : sp){
			if(Integer.parseInt(s) == matchTo){
				isMatched = true;
				if(isMatched){
					System.out.println(matchTo);
				}
			}
		}
		
		
		
        //int N = Integer.parseInt(line1);
        
	}

}
