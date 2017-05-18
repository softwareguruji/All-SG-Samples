package techgig.codegladiator.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenWomenMatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = new String[5];
		
		//Input1
		/*arr[0] = "M1#W2#W4";
		arr[1] = "M2#W1#W2";
		arr[2] = "M3#W1#W3#W4";
		arr[3] = "M4#W4#W5";
		arr[4] = "M5#W4";*/
		
		//Input2
		/*arr[0] = "M1#W4";
		arr[1] = "M2#W1#W2";
		arr[2] = "M3#W1#W3#W4";
		arr[3] = "M4#W4#W5";
		arr[4] = "M5#W4";*/
		
		//Input3
		arr = new String[10];
		arr[0] = "M1#W6#W10";
		arr[1] = "M2#W1#W5";
		arr[2] = "M3#W1#W3#W5#w9";
		arr[3] = "M4#W3#W4";
		arr[4] = "M5#W2#W6";
		arr[5] = "M6#W1#W2#W6";
		arr[6] = "M7#W1#W7#W8";
		arr[7] = "M8#W8#W10";
		arr[8] = "M9#W3#W9";
		arr[9] = "M10#W10";
		
		System.out.println(totalMatching(arr));
	}

	private static int totalMatching(String[] input) {

		Map<String, ArrayList<String>> manLikingMap = new HashMap<>();
		
		for (String in : input) {
			String[] inArr = in.split("#");
			if(inArr.length <= 1){
				return -1;
			}
			manLikingMap.put(inArr[0], new ArrayList<>(Arrays.asList(Arrays.copyOfRange(inArr, 1, inArr.length))));
		}

		for(int i=0; i<10; i++){
			showMap(manLikingMap);
			//Remove other link for liking women if any man has linking for one woman only.
			Set<String> manList = manLikingMap.keySet();
			for (String man : manList) {
				if(manLikingMap.get(man).size() == 1){
					String womanName = manLikingMap.get(man).get(0);
					for (String man1 : manList) {
						if(!man.equals(man1)
								&& manLikingMap.get(man1).contains(womanName)){
							manLikingMap.get(man1).remove(womanName);

							//If 2 man liking to same woman and none of tham had any choice than return -1 
							if(manLikingMap.get(man1).size() == 0){
								return -1;
							}
						}
					}		
				}
			}
		}
		
		showMap(manLikingMap);
		
		//Finding duplicates which is our answer
		int maxPossiblitity = 0;
		Set<String> manList = manLikingMap.keySet();
		for (String man : manList) {
			//System.out.println(man+" : "+manLikingMap.get(man).toString());
			maxPossiblitity = maxPossiblitity < manLikingMap.get(man).size() ? manLikingMap.get(man).size() : maxPossiblitity;
		}
		
		return maxPossiblitity;
	}
	
	private static void showMap(Map<String, ArrayList<String>> manLikingMap){
		System.out.println("------------");
		Set<String> manList = manLikingMap.keySet();
		for (String man : manList) {
			System.out.println(man+" : "+manLikingMap.get(man).toString());
		}
	}

}
