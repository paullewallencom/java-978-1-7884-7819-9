package section3_recipe1;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private final Semaphore semaphore;
	private final boolean freePrinters[];
	private final Lock lockPrinters;
	
	public PrintQueue(){
		semaphore=new Semaphore(3);
		freePrinters=new boolean[3];
		for (int i=0; i<3; i++){
			freePrinters[i]=true;
		}
		lockPrinters=new ReentrantLock();
	}
	
	public void printJob (Object document){
		try {
			semaphore.acquire ();
			
			int assignedPrinter=getPrinter ();
			
			Long duration=(long)(Math.random()*10);
			System.out.printf("%s - %s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",new Date(),Thread.currentThread().getName(),assignedPrinter,duration);
			TimeUnit.SECONDS.sleep(duration);
			
			// Free the printer
			freePrinters[assignedPrinter]=true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Free the semaphore
			semaphore.release();	
		}
	}
	
	private int getPrinter(){
		int ret=-1;
		
		try {
			lockPrinters.lock();
			// Look for the first free printer
			for (int i=0; i<freePrinters.length; i++) {
				if (freePrinters[i]){
					ret=i;
					freePrinters[i]=false;
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Free the access to the array
			lockPrinters.unlock();
		}
		return ret;
	}

}
