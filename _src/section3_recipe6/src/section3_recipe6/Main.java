package section3_recipe6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import section3_recipe6.Consumer;
import section3_recipe6.Producer;

public class Main {
	public static void main(String[] args){
		
		List<String> buffer1=new ArrayList<>();
		List<String> buffer2=new ArrayList<>();
		
		Exchanger<List<String>> exchanger=new Exchanger<>();
		
		// Creates the producer
		Producer producer=new Producer(buffer1, exchanger);
		// Creates the consumer
		Consumer consumer=new Consumer(buffer2, exchanger);
		
		// Creates and starts the threads
		Thread threadProducer=new Thread(producer);
		Thread threadConsumer=new Thread(consumer);
		
		threadProducer.start();
		threadConsumer.start();
		
	}

}
