package learn.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadDemo {
	public static void main(String[] args) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
		//		newScheduledThreadPool.scheduleWithFixedDelay(command, initialDelay, delay, unit)
		newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() {

			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(System.currentTimeMillis() / 1000);

			}
		}, 0, 2, TimeUnit.SECONDS);
	}
}
