package section1_recipe7;

import section1_recipe7.ExceptionHandler;
import section1_recipe7.Task;

public class Main {
	public static void main(String[] args){
		
		// Creates the Task
				Task task = new Task();
				// Creates the Thread
				Thread thread = new Thread(task);
				// Sets de uncaugh exceptio handler
				thread.setUncaughtExceptionHandler(new ExceptionHandler());
				// Starts the Thread
				thread.start();

				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.printf("Thread has finished\n");
		
	}

}
