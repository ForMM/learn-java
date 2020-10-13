package learn.thread;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car car) {
		super();
		this.car = car;
	}

	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("Wax on!");
			try {
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			} catch (InterruptedException e) {
				System.out.println("exit via interrupt");
			}
		}
		System.out.println("涂蜡结束");
	}

}
