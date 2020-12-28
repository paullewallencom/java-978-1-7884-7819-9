package section3_recipe1;

import section3_recipe1.PrintQueue;
import section3_recipe1.Job;

public class Main {
	public static void main(String[] args){
		
		PrintQueue printQueue=new PrintQueue();
		
		// Creates twelve Threads
		Thread[] threads=new Thread[12];
		for (int i=0; i < threads.length; i++){
			threads[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		// Starts the Threads
		for (int i=0; i < threads.length; i++){
			threads[i].start();
		}
		
	}

}
