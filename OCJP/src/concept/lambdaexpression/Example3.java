package concept.lambdaexpression;

public class Example3 {

	/*
	 * This is the Lambda - Java 8 way to pass the Behaviour in to method.
	 */
	public static void main(String[] args) {
		Example3 ex3 = new Example3();
		Example3_LambdaBehaviour display = () -> System.out.println("Calling Behaviour in Lamdaway");
		display.display();
		
		
	}
	

}
