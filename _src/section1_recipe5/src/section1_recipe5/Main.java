package section1_recipe5;

import java.util.Date;

import section1_recipe5.DataSourcesLoader;
import section1_recipe5.NetworkConnectionsLoader;

public class Main {
	public static void main(String[] args){
				// Creates and starts a DataSourceLoader runnable object
				DataSourcesLoader dsLoader = new DataSourcesLoader();
				Thread thread1 = new Thread(dsLoader,"DataSourceThread");

				// Creates and starts a NetworkConnectionsLoader runnable object
				NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
				Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
				
				thread1.start();
				thread2.start();
				
				// Wait for the finalization of the two threads
				try {
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Waits a message
				System.out.printf("Main: Configuration has been loaded: %s\n",new Date());

	}

}
