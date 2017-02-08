package concept.thread;

import java.util.Date;

/*

yield() will just say thread controller to put it self to Runnable step from current running state. But that is not guarantee that it 
will go to the runnable stage. It is all depends on the thread controller weather to put it or not.  

 */
public class YieldExample{

	public static void main(String[] args) {

		Example e1 = new Example("Ketan",2);
		Example e2 = new Example("Disha",4);
		Example e3 = new Example("Arth",6);
		Example e4 = new Example("Rasiklal",8);
		Example e5 = new Example("Geetaben",10);
		
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
	}
	
	static class Example extends Thread{
		
		int counter;
		String name;
		int maxOccurance;
		
		public Example(String name, int priority) {
			this.name = name;
			this.setPriority(priority);
			this.maxOccurance = priority;
		}

		@Override
		public void run() {
			try {
				for( ; ; ){
					Thread.sleep(1000);
					if((name.equals("Ketan") || name.equals("Disha") || name.equals("Arth")) && counter >= 2){
						Thread.yield();
					}
					if(counter == maxOccurance){
						break;
					}
					System.out.println(counter++ +" :: Name: "+name+" "+(new Date()).getTime());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
