package techgig.exams;

public class Sample1 {

	public static void main(String[] args) {
		String a[] = new String[5];
		a[0] = "E#D#E#E#E";
		a[1] = "D#I#S#K#E";
		a[2] = "E#S#E#E#E";
		a[3] = "E#C#E#E#E";
		a[4] = "E#E#E#E#E";
		
		String s = "DISK";
		
		System.out.println(word_count(a, s));
	}

	public static int word_count(String[] arr,String strToCheck)
    {
		int cnt = 0;
        
		//Check in Horizontal way
	    for(int i=0; i<arr.length; i++){
	    	String s = arr[i].replace("#","");
	    	if(s.contains(strToCheck))
	    		cnt++;
	    }
	    
	    //check in Vertical way
	    for(int i=0; i<arr.length; i++){

	    	String s = "";
	    	for(int j=0; j<arr.length; j++){
	    		s+=arr[j].split("#")[i];
	    	}

	    	if(s.contains(strToCheck))
	    		cnt++;
	    }
	    
	    //check in Diagonal way Top to Bottom
	    String s = "";
	    for(int j=0; j<arr.length; j++){
	    	s+=arr[j].split("#")[j];
	    }
	    if(s.contains(strToCheck))
	    	cnt++;

	    //check in Diagonal way Bottom to Top
	    s = "";
	    for(int j=arr.length-1; j>=0; j--){
	    	s+=arr[j].split("#")[(arr.length-1)-j];
	    }
	    if(s.contains(strToCheck))
	    	cnt++;

	    return cnt;
    }
}
