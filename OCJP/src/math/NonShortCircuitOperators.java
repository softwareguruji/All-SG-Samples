package math;

/*
 * It's non short circuit '&' and '|' operator. 
 * In case of non short circutit operator it will check all the operation though first condition true in case of | and first condition is false in case of &.
 */
public class NonShortCircuitOperators {

	public static void main(String[] args) {
		int x = 1;
		
		if(++x > 10 && ++x > 12);
		System.out.println(x);
		
		x = 1;
		if(++x > 10 & ++x > 12);
		System.out.println(x);

		x = 1;
		if(++x < 10 || ++x < 12);
		System.out.println(x);
		
		x = 1;
		if(++x < 10 | ++x < 12);
		System.out.println(x);

		x = 1;
		if((4 > x) ^ ((++x + 2) > 3)){
			x ++;
		}
		
		System.out.println(x);
	}
}
