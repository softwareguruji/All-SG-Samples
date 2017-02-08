package techgig.xelcior;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectedBridge {

	//connected - if move 1 iceland to other iceland
	//critical - removing that bridge break connection of that iceland.
	public static void main(String[] args) {
		//System.out.println(criticalBridges(1, "({A,B,C,D,E,F},{(A,C),(B,C),(C,E),(B,E),(B,D),(E,F)})")); 
		
		System.out.println(criticalBridges(2, "({A,B,C},{(A,B),(B,C),(C,A)}),({A,B,C,D,E},{(A,B),(B,C),(C,A),(E,D),(D,A)})")); 
	}
	
	public static String criticalBridges(int noOfTestCases, String testCases){
		StringBuffer outputBuilder = new StringBuffer();

		
		String[] testCase = testCases.split("\\}\\),\\(\\{");
		
		for(int i=0; i<noOfTestCases; i++){

			String subTestCase = testCase[i];
			
			if(noOfTestCases > 1){
				if(i == 0){
					subTestCase = subTestCase + "})";
				}else if(i == noOfTestCases - 1){
					subTestCase = "({"+subTestCase;
				}else{
					subTestCase = "({"+subTestCase+"})";
				}
			}
			
			subTestCase = subTestCase.substring(1, subTestCase.length()-1);
			System.out.println(subTestCase);
			
			HashMap<String, Set<String>> iceLandLinkMap = new HashMap<>();
			HashMap<String, Iceland> icelandObjectMap = new HashMap<>();
			
			String iceLands = subTestCase.split("\\},\\{")[0]+"}";
			iceLands = iceLands.substring(1, iceLands.length()-1);
			System.out.println(iceLands);
			
			for (String s : iceLands.split(",")) {
				iceLandLinkMap.put(s, new HashSet<String>());
			}

			String connections = "{"+subTestCase.split("\\},\\{")[1];
			connections = connections.substring(2, connections.length()-2);
			System.out.println(connections);
			
			
			for (String bridge : connections.split("\\),\\(")) {
				System.out.println(bridge);
				iceLandLinkMap.get(bridge.split(",")[0]).add(bridge.split(",")[1]);
				iceLandLinkMap.get(bridge.split(",")[1]).add(bridge.split(",")[0]);
				
				//another way
				if(icelandObjectMap.get(bridge.split(",")[0]) == null){
					Iceland icelandObj = new Iceland(bridge.split(",")[0]);
					icelandObjectMap.put(bridge.split(",")[0], icelandObj);
				}
				
				if(icelandObjectMap.get(bridge.split(",")[1]) == null){
					Iceland icelandObj = new Iceland(bridge.split(",")[1]);
					icelandObjectMap.put(bridge.split(",")[1], icelandObj);
				}
				
				Iceland leftSide = icelandObjectMap.get(bridge.split(",")[0]);
				Iceland rightSide = icelandObjectMap.get(bridge.split(",")[1]);
				leftSide.addConnectedIceland(rightSide);
				
			}
			
			Set<String> keys = iceLandLinkMap.keySet();
			for (String key : keys) {
				System.out.println(key + " : "+iceLandLinkMap.get(key).size()+ " : "+iceLandLinkMap.get(key));
			}

			//Verify with another way.
			for(String key : icelandObjectMap.keySet()){
				Iceland ice = icelandObjectMap.get(key);
				for(String key1 : icelandObjectMap.keySet()){
					if(!key.equals(key1)){
						Iceland ice1 = icelandObjectMap.get(key1);
						System.out.println(ice.name+" : "+ice1.name+" : "+ice.canConnect(ice1));
					}
				}
			}
			
			
			System.out.println("Output....");
			connections = "("+connections+")";
			
			StringBuffer subOutputBuilder = new StringBuffer();
			/*for (String key : keys) {
				if(iceLandLinkMap.get(key).size()==1){
					String val = "("+key+","+iceLandLinkMap.get(key).toArray()[0]+")";
					if(connections.contains(val)){
						subOutputBuilder.append(val+",");
					}else{
						val = "("+iceLandLinkMap.get(key).toArray()[0]+","+key+")";
						subOutputBuilder.append(val+",");
					}
				}
			}*/
	
			if(subOutputBuilder.length() == 0){
				outputBuilder.append("{NA}");
			}else{
				outputBuilder.append("{"+subOutputBuilder.substring(0, subOutputBuilder.length()-1)+"}");
			}
		}
				
		System.out.println(outputBuilder);
		return outputBuilder.toString();
	}
	
	
	
}
