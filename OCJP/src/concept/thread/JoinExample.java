package concept.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/*

Join() :

 */
public class JoinExample{

	public static void main(String[] args) {

		Example e1 = new Example("Ketan",4,5, null);
		Example e2 = new Example("Disha",4,5, e1); //Means e2 will be blocked until e1's task is completed. Reference. https://www.journaldev.com/1024/java-thread-join-example 
		Example e3 = new Example("Arth",6,5, null);
		Example e4 = new Example("Rasiklal",2,5, null);
		Example e5 = new Example("Geetaben",10,5, null);
		
		e1.start();
		e2.start();
		/*try {
			e2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		e3.start();
		e4.start();
		e5.start();
	}
	
	static class Example extends Thread{
		
		int counter;
		String name;
		int maxOccurance;
		Thread e;
		
		public Example(String name, int priority, int maxCoccurance, Thread e) {
			this.name = name;
			this.setPriority(priority);
			this.maxOccurance = maxCoccurance;
			this.e = e;
		}

		@Override
		public void run() {
			if(this.e != null){
				try {
					this.e.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				for( ; ; ){
					Thread.sleep(1000);
					if(counter == maxOccurance){
						break;
					}
					
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss S");
					System.out.println(counter++ +" :: Name: "+name+" "+sdf.format(new Date()));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
