package concept.thread;

public class Weather {

	public static void main(String[] args) {
		Forecaster fc = new Forecaster();
		new Listener(fc, "Ketan");
		new Listener(fc, "Disha");
		new Listener(fc, "Arth");
		
	}

	static class Forecaster extends Thread{
		
		private int tomorrowsTemperature;
		public Forecaster() {
			start();
		}
		
		@Override
		public void run() {
			try {
				for ( ; ; ) {
					sleep(1000);
					synchronized (this) {
						tomorrowsTemperature = (int) (40 * Math.random() - 10);
						//notifyAll();
						notify();
					}	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public synchronized int getTomorrowsTemperature() {
			return tomorrowsTemperature;
		}
	}
	
	static class Listener extends Thread{
		
		private final Forecaster forecaster;
		private final String listenerName;
		
		public Listener(Forecaster forecaster, String name) {
			this.forecaster = forecaster;
			this.listenerName = name;
			start();
		}
		
		@Override
		public void run() {
			try {
				for( ; ; ){
					synchronized (forecaster) {
						forecaster.wait();
					}
					System.out.println(listenerName+" hear tomorrow's temarature will be "+forecaster.getTomorrowsTemperature()+" degree Ceceious.");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


