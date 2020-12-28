package section2_recipe3;

import java.util.concurrent.TimeUnit;

import section2_recipe3.Job;
import section2_recipe3.PrintQueue;

public class Main {
	public static void main(String[] args){
		
		System.out.printf("Running example with fair-mode = false\n");
		testPrintQueue(false);
		System.out.printf("Running example with fair-mode = true\n");
		testPrintQueue(true);	
	}
	
	private static void testPrintQueue(boolean fairMode) {
		// Creates the print queue
		PrintQueue printQueue=new PrintQueue(fairMode);
		
		// Creates ten Threads
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		// Starts the Threads
		for (int i=0; i<10; i++){
			thread[i].start();
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
		
		// Wait for the end of the threads
		for (int i=0; i<10; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
