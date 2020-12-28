package section2_recipe4;

import java.util.Date;

public class Writer implements Runnable {
	
	private PricesInfo pricesInfo;
	
	public Writer(PricesInfo pricesInfo){
		this.pricesInfo=pricesInfo;
	}
	
	@Override
	public void run() {
		for (int i=0; i<3; i++) {
			System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
			pricesInfo.setPrices(Math.random()*10, Math.random()*8);
			System.out.printf("%s: Writer: Prices have been modified.\n", new Date());
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
