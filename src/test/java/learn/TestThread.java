package learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import learn.thread.Car;
import learn.thread.WaxOff;
import learn.thread.WaxOn;

public class TestThread {

	@Test
	public void test() throws InterruptedException {
		Car car = new Car();

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		newCachedThreadPool.execute(new WaxOff(car));
		//		newCachedThreadPool.execute(new WaxOn(car));
		TimeUnit.MILLISECONDS.sleep(5);
		newCachedThreadPool.shutdown();

	}

}
