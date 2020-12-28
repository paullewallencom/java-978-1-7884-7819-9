package section1_recipe10;

import section1_recipe10.MyThreadFactory;
import section1_recipe10.Task;

public class Main {
	public static void main(String[] args){
		
		MyThreadFactory factory=new MyThreadFactory("My ThreadFactory");
		Task task=new Task();
		
		Thread thread;

		// Creates and starts ten Thread objects
		System.out.printf("Starting the Threads\n");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		
		// Prints the statistics of the ThreadFactory to the console
				System.out.printf("Factory stats:\n");
				System.out.printf("%s\n", factory.getStats());
		
	}

}
