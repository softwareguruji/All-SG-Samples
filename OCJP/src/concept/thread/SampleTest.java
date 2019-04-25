package concept.thread;

import java.util.ArrayList;
import java.util.Iterator;

public class SampleTest {

	public static void main(String[] args) {

		int nTC = Integer.parseInt("1");                // Reading input from STDIN

        for(int i=0; i<nTC; i++){
            String[] tR = "4 1 2".split(" ");
            int arrSize = Integer.parseInt(tR[0]);
            int noOfRemoveElements = Integer.parseInt(tR[1]);
            int kThElement = Integer.parseInt(tR[2]);
            
            ArrayList<Integer> aI = new ArrayList<>();
            for(int j=1; j<=arrSize; j++){
                aI.add(j);
            }
            
            String rS[] = "1".split(" ");
            for(int j=0; j<rS.length; j++){
                Iterator<Integer> aII = aI.iterator();
                while (aII.hasNext()){
                  if(aII.next().equals(Integer.parseInt(rS[j]))){
                      aII.remove();
                  }
                }
            }
            
            if(aI.size() >= kThElement){
                System.out.println(aI.get(kThElement-1));
            }else{
                System.out.println("-1");
            }
        }
	}

}
