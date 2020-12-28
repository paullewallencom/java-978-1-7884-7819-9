package section2_recipe2;

public class Producer implements Runnable {
	
	private EventStorage storage;
	
	public Producer(EventStorage storage){
		this.storage=storage;
	}
	
	/**
	 * Core method of the producer. Generates 100 events.
	 */
	@Override
	public void run() {
		for (int i=0; i<100; i++){
			storage.set();
		}
	}

}
