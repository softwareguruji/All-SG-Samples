package techgig.codegladiator.practice;

public class BinarySwitchOperation {

	public static void main(String[] args) {
		System.out.println(nochange_bits("10110101101", 3, 4));
	}
	
	public static int nochange_bits(String bStr,int firstConv,int secondConv)
    {
		
		if(firstConv <= 0 || secondConv <= 0)
			return -1;
		
        StringBuffer sbBStr = new StringBuffer(bStr);
	    for(int i=0; i<sbBStr.length(); i++){
	        if((i+1) % firstConv == 0){
	        	char binary = sbBStr.charAt(i);
	        	switch(binary){
	        		case '0': sbBStr.setCharAt(i, '1');
	        			 	break;
	        		case '1': sbBStr.setCharAt(i, '0');
    			 			break;	        			  
	        	}
	        }
	    }
	    for(int i=0; i<sbBStr.length(); i++){
	        if((i+1) % secondConv == 0){
	        	char binary = sbBStr.charAt(i);
	        	switch(binary){
	        		case '0': sbBStr.setCharAt(i, '1');
	        			 	break;
	        		case '1': sbBStr.setCharAt(i, '0');
    			 			break;	        			  
	        	}
	        }
	    }
	    
	    int increment = 0;
	    for(int i=0; i<sbBStr.length(); i++){
        	if(sbBStr.charAt(i) == bStr.charAt(i)){
        		increment++;
        	}
	    }
	    
	    return increment;
    }

}
