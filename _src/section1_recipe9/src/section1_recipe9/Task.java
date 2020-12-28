package section1_recipe9;

import java.util.Random;

public class Task implements Runnable{
	
	@Override
	public void run() {
		int result;
		// Create a random number generator
		Random random=new Random(Thread.currentThread().getId());
		while (true) {
			// Generate a random number and calculate 1000000000 divide by that random number
			result=1000/((int)(random.nextDouble()*1000000000));
			// Check if the Thread has been interrupted
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
				return;
			}
		}
	}

}
