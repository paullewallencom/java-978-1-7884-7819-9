package section2_recipe5;

import section2_recipe5.Buffer;
import section2_recipe5.Consumer;
import section2_recipe5.Producer;
import section2_recipe5.FileMock;

public class Main {
	public static void main(String[] args){
		
		FileMock mock = new FileMock(100, 10);
		
		Buffer buffer = new Buffer(20);
		
		Producer producer = new Producer(mock, buffer);
		Thread producerThread = new Thread(producer,"Producer");
		
		/**
		 * Creates three consumers and threads to run them
		 */
		Consumer consumers[] = new Consumer[3];
		Thread consumersThreads[] = new Thread[3];

		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumer(buffer);
			consumersThreads[i] = new Thread(consumers[i], "Consumer " + i);
		}

		/**
		 * Strats the producer and the consumers
		 */
		producerThread.start();
		for (int i = 0; i < 3; i++) {
			consumersThreads[i].start();
		}
		
	}

}
