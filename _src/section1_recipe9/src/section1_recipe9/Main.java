package section1_recipe9;

import section1_recipe9.MyThreadGroup;
import section1_recipe9.Task;

public class Main {
	public static void main(String[] args){
		int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
		
		MyThreadGroup threadGroup=new MyThreadGroup("My ThreadGroup");
		
		Task task=new Task();
		
		// Create the thread objects associated to the threadGroup
				for (int i = 0; i < numberOfThreads; i++) {
					Thread t = new Thread(threadGroup, task);
					t.start();
				}
		
				// Write information about the ThreadGroup to the console
				System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
				System.out.printf("Information about the Thread Group\n");
				threadGroup.list();
				
				// Write information about the status of the Thread objects to the
				// console
				Thread[] threads = new Thread[threadGroup.activeCount()];
				threadGroup.enumerate(threads);
				for (int i = 0; i < threadGroup.activeCount(); i++) {
					System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
				}

	}

}
