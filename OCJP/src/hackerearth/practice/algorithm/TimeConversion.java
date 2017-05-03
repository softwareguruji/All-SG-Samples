package hackerearth.practice.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner in = new Scanner(System.in);
        String time = "07:05:45PM";
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ssa");
        Date date = sdf.parse(time);
        System.out.println(date);
	}

}
