package learn.thread.lock.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
	private Semaphore semaphore;
	private String name;

	public Worker(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;
	}

	public void run() {
		try {
			//干活之前获取令牌
			this.semaphore.acquire();
			this.doWork();
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
			System.out.println(this.name + ",活干完了");

			//释放令牌
			this.semaphore.release();
			System.out.println("当前可用令牌数量：" + this.semaphore.availablePermits());
		} catch (InterruptedException ie) {

		}
	}

	public void doWork() {
		System.out.println(name + ",正在干活");
	}
}
