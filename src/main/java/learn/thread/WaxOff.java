package learn.thread;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;
	
	public WaxOff(Car car) {
		super();
		this.car = car;
	}

	public void run() {
		while(!Thread.interrupted()) {
			try {
				System.out.println("wax off!");
				car.waitForWaxing();
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			} catch (InterruptedException e) {
				System.out.println("exit via interrupt");
			}
		}
		System.out.println("涂蜡结束");
	}

}
