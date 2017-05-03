package techgig.codegladiator.practice;

import java.util.function.*;

public class BinarySwitchOperation_Lambda {

	public static void main(String[] args) {
		System.out.println(nochange_bits("10110101101", 3, 4));
	}
	
	public static int nochange_bits(final String bStr,final int firstConv,final int secondConv)
    {
		
		if(firstConv <= 0 || secondConv <= 0)
			return -1;
		
        StringBuffer sbBStr = new StringBuffer(bStr);
        
	    check(sbBStr, firstConv);
	    /*test t = (sbBStr1, firstConv1) -> {
	    	for(int i=0; i<sbBStr1.length(); i++){
				if((i+1) % firstConv1 == 0){
					char binary = sbBStr1.charAt(i);
					switch(binary){
					case '0': sbBStr1.setCharAt(i, '1');
					break;
					case '1': sbBStr1.setCharAt(i, '0');
					break;	        			  
					}
				}
			}	
	    };*/
	    
	    check(sbBStr, secondConv);
	    
	    int increment = 0;
	    for(int i=0; i<sbBStr.length(); i++){
        	if(sbBStr.charAt(i) == bStr.charAt(i)){
        		increment++;
        	}
	    }
	    
	    return increment;
    }
	
	public static void check(StringBuffer sbBStr, int conv){
		for(int i=0; i<sbBStr.length(); i++){
			if((i+1) % conv == 0){
				char binary = sbBStr.charAt(i);
				switch(binary){
				case '0': sbBStr.setCharAt(i, '1');
				break;
				case '1': sbBStr.setCharAt(i, '0');
				break;	        			  
				}
			}
		}
	}
	

	@FunctionalInterface
	interface test{
		public void test(StringBuffer sb, int conv);
	}
}
