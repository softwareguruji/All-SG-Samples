package concept.lambdaexpression;

/*
 * This is overriden and interface implementation way for calling pre-build behaviour.
 * This is Java 7 or earlier way.
 */
public class Example2 {

	public static void main(String[] args) {
		Example2 e2 = new Example2();
		e2.displayCall(new Example2_Behaviour1());
		e2.displayCall(new Example2_Behaviour2());
	}

	public void displayCall(Example2_Interface e2BehaviourObj){
		e2BehaviourObj.display("World");
	}
	
}
