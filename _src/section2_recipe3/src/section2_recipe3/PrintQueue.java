package section2_recipe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private Lock queueLock;
	
	public PrintQueue(boolean fairMode){
		queueLock= new ReentrantLock(fairMode);
	}
	
	public void printJob(Object document){
		queueLock.lock();
		
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					(duration / 1000));
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		finally {
			queueLock.unlock();
		}
		
		queueLock.lock();
		
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					(duration / 1000));
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		finally {
			queueLock.unlock();
		}
	}

}
