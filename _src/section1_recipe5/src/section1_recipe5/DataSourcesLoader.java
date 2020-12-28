package section1_recipe5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable {
	
	@Override
	public void run() {
		
		// Writes a messsage
		System.out.printf("Begining data sources loading: %s\n",new Date());
		// Sleeps four seconds
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Writes a message
		System.out.printf("Data sources loading has finished: %s\n",new Date());
	}

}
