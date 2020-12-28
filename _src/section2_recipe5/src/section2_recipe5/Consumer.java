package section2_recipe5;

import java.util.Random;

public class Consumer implements Runnable {
	
	private Buffer buffer;
	
	public Consumer (Buffer buffer){
		this.buffer=buffer;
	}
	
	/**
	 * Core method of the consumer. While there are pending lines in the buffer,
	 * try to read one.
	 */
	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}

	/**
	 * Method that simulates the processing of a line. Waits 10 milliseconds
	 * 
	 * @param line
	 */
	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
