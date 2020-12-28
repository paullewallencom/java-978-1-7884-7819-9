package section1_recipe6;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import section1_recipe6.Event;
import section1_recipe6.CleanerTask;
import section1_recipe6.WriterTask;

public class Main {
	public static void main(String[] args){
		
		Deque<Event> deque=new ConcurrentLinkedDeque<Event>();
		
		// Creates the three WriterTask and starts them
				WriterTask writer = new WriterTask(deque);
				for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
					Thread thread = new Thread(writer);
					thread.start();
				}

				// Creates a cleaner task and starts them
				CleanerTask cleaner = new CleanerTask(deque);
				cleaner.start();
		
	}

}
