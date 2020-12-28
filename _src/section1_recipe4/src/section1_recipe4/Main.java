package section1_recipe4;

import java.util.concurrent.TimeUnit;

import section1_recipe4.ConsoleClock;

public class Main {
	public static void main(String[] args){
		// Creates a FileClock runnable object and a Thread
				// to run it
				ConsoleClock clock = new ConsoleClock();
				Thread thread = new Thread(clock);

				// Starts the Thread
				thread.start();
				
				try {
					// Waits five seconds
					TimeUnit.SECONDS.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				thread.interrupt();
	}

}
