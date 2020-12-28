package section2_recipe6;

import java.util.concurrent.locks.StampedLock;

import section2_recipe6.OptimisticReader;
import section2_recipe6.Position;
import section2_recipe6.Reader;
import section2_recipe6.Writer;

public class Main {
	public static void main(String[] args){
		
		Position position=new Position();
		StampedLock lock=new StampedLock();
		
		Thread threadWriter=new Thread(new Writer(position,lock));
		Thread threadReader=new Thread(new Reader(position, lock));
		Thread threadOptReader=new Thread(new OptimisticReader(position, lock));
		
		threadWriter.start();
		threadReader.start();
		threadOptReader.start();
		
		try {
			threadWriter.join();
			threadReader.join();
			threadOptReader.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
