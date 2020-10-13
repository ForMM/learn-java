package learn.thread;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		super();
		this.car = car;
	}

	public void run() {
		while (true) {
			try {
				new TestSync().set("asdf", "asdfa");
			} catch (Exception e) {
				System.out.println("exit via interrupt");
			}
		}
	}

}
