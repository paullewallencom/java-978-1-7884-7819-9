package section1_recipe2;

import java.util.concurrent.TimeUnit;

import section1_recipe2.PrimeGenerator;

public class Main {
	public static void main(String[] args){
		Thread task = new PrimeGenerator();
		task.start();

		// Wait 5 seconds
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Interrupt the prime number generator
				task.interrupt();
				
				// Write information about the status of the Thread
				System.out.printf("Main: Status of the Thread: %s\n", task.getState());
				System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
				System.out.printf("Main: isAlive: %s\n", task.isAlive());
	}
}
