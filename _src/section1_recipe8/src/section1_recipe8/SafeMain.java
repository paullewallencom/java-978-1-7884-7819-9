package section1_recipe8;

import java.util.concurrent.TimeUnit;

import section1_recipe8.SafeTask;

public class SafeMain {
	public static void main(String[] args){
		// Creates a task
				SafeTask task = new SafeTask();

				// Creates and start three Thread objects for that Task
				for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
					Thread thread = new Thread(task);
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					thread.start();
				}
	}

}
