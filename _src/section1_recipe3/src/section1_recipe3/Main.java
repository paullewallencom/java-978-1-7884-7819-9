package section1_recipe3;

import java.util.concurrent.TimeUnit;

import section1_recipe3.FileSearch;

public class Main {
	public static void main(String[] args){
		// Creates the Runnable object and the Thread to run it
				FileSearch searcher = new FileSearch("C:\\Windows", "explorer.exe");
				Thread thread = new Thread(searcher);

				// Starts the Thread
				thread.start();
				
				// Wait for ten seconds
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Interrupts the thread
				thread.interrupt();
	}

}
