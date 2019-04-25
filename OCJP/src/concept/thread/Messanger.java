package concept.thread;

public class Messanger implements Runnable{

	String message;
	
	public Messanger(String message) {
		this.message = message;
	}
	
	public static void main(String[] args) {
		new Thread(new Messanger("First")).start();
		new Thread(new Messanger("Two")).start();
		/*new Thread(new Messanger("Three")).start();
		new Thread(new Messanger("Four")).start();
		new Thread(new Messanger("Five")).start();
		new Thread(new Messanger("Six")).start();
		new Thread(new Messanger("Seven")).start();
		new Thread(new Messanger("Eight")).start();*/
	}
	
	@Override
	public void run(){
		try{ //Message Print 1 & 2 will be always in sequence but First/Two/Three... all can be random as they are actal threads.
			messagePrint(1);
			messagePrint(2);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public synchronized void messagePrint(int a) throws InterruptedException{
		System.out.println("-- "+message+" -- "+a);
		
	}
}
