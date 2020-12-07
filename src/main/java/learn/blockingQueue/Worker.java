package learn.blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有两个线程A,B, A线程每200ms就生成一个[0,100]之间的随机数， B线程每2S中打印出A线程所产生的增量随机数。
 */
public class Worker implements Runnable {
	private volatile boolean isRunning = true;
	private BlockingQueue blockingQueue;
	private String name;
	private static AtomicInteger count = new AtomicInteger();

	public Worker(BlockingQueue blockingQueue, String name) {
		this.blockingQueue = blockingQueue;
		this.name = name;
	}

	public void run() {
		System.out.println("启动生产者线程：" + this.name);
		Random random = new Random();
		try {
			while (isRunning) {

			}
		} catch (Exception e) {

		} finally {
			System.out.println("退出生产者线程：" + this.name);
		}


	}

	public void stop() {
		isRunning = false;
	}

}
