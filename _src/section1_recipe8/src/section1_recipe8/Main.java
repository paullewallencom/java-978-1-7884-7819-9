package section1_recipe8;

import java.util.concurrent.TimeUnit;

import section1_recipe8.UnsafeTask;

public class Main {
	public static void main(String[] args){
		
		// Creates the unsafe task
				UnsafeTask task = new UnsafeTask();

				// Throw ten Thread objects
				for (int i = 0; i < 10; i++) {
					Thread thread = new Thread(task);
					thread.start();
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		
	}

}
